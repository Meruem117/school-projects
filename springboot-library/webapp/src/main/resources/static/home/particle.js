function render(dotsCount) {
  var canvas = document.querySelector('#background');
  var ctx = canvas.getContext('2d');   //画布绘图环境
  // canvas.width = window.innerWidth;
  // canvas.height = window.innerHeight;
  canvas.width = $(window).width();
  canvas.height = $(window).height();
  ctx.lineWidth = 0.3;  //线条宽度
  ctx.strokeStyle = (new Color(150)).style; //填充颜色

  //初始位置
  var mousePosition = {
    x: canvas.width / 2,
    y: canvas.height / 2
  };

  var dots = {
    nb: dotsCount,  //粒子数量
    distance: 100, //连接范围
    d_radius: 200, //辐射半径
    array: [] //接收粒子信息（位置，大小，颜色）
  };

  function colorValue(min) {
    return Math.floor(Math.random() * 255 + min);  //随机生成min-256之间的整数
  }

  function createColorStyle(r,g,b) {
    return 'rgba(' + r + ',' + g + ',' + b + ', 0.8)'; //返回RGBA颜色，增加了alpha透明度
  }

  function mixComponents(comp1, weight1, comp2, weight2) {
    return (comp1 * weight1 + comp2 * weight2) / (weight1 + weight2); //渐变方程
  }

  function averageColorStyles(dot1, dot2) {
    var color1 = dot1.color,
    color2 = dot2.color;
    //线性方程混合颜色取值
    var r = mixComponents(color1.r, dot1.radius, color2.r, dot2.radius),
    g = mixComponents(color1.g, dot1.radius, color2.g, dot2.radius),
    b = mixComponents(color1.b, dot1.radius, color2.b, dot2.radius);
    return createColorStyle(Math.floor(r), Math.floor(g), Math.floor(b));
  }

  function Color(min) {
    min = min || 0;
    this.r = colorValue(min);
    this.g = colorValue(min);
    this.b = colorValue(min);
    this.style = createColorStyle(this.r, this.g, this.b);
  }

  function Dot(){
    //生成0~窗口宽度/高度的随机坐标
    this.x = Math.random() * canvas.width;
    this.y = Math.random() * canvas.height;

    //生成-0.5 ~ 0.5之间的x轴/y轴随机速度
    this.vx = -0.5 + Math.random();
    this.vy = -0.5 + Math.random();

    this.radius = Math.random() * 5;  //生成0~5之间的随机半径
    this.color = new Color(); //生成随机颜色
  }

  Dot.prototype = {
    draw: function(){
    ctx.beginPath(); //开始一条路径
    ctx.fillStyle = this.color.style;  //填充颜色
    ctx.arc(this.x, this.y, this.radius, 0, Math.PI * 2, false); //参数：坐标，半径，起始角，结束角，顺时针
    ctx.fill();  //填充路径
    }
  };

  function createDots(){
    for(i = 0; i < dots.nb; i++){
      dots.array.push(new Dot());
    }
  }

  function moveDots() {
    for(i = 0; i < dots.nb; i++){
      var dot = dots.array[i];
      //运动到窗口边缘反弹回来
      if(dot.y < 0 || dot.y > canvas.height){
        dot.vx = dot.vx;
        dot.vy = - dot.vy;
      }
      else if(dot.x < 0 || dot.x > canvas.width){
        dot.vx = - dot.vx;
        dot.vy = dot.vy;
      }
      //新的x轴位置等于当前x轴位置加x轴速度，y轴同理
      dot.x += dot.vx;
      dot.y += dot.vy;
    }
  }

  function connectDots() {
    for(i = 0; i < dots.nb; i++){
      for(j = 0; j < dots.nb; j++){
        i_dot = dots.array[i];
        j_dot = dots.array[j];
        //两点之间的距离小于distance，同时两点也在鼠标所在位置的d_radius范围内时，触发连线
        if((i_dot.x - j_dot.x) < dots.distance && (i_dot.y - j_dot.y) < dots.distance && (i_dot.x - j_dot.x) > - dots.distance && (i_dot.y - j_dot.y) > - dots.distance){
          if((i_dot.x - mousePosition.x) < dots.d_radius && (i_dot.y - mousePosition.y) < dots.d_radius && (i_dot.x - mousePosition.x) > - dots.d_radius && (i_dot.y - mousePosition.y) > - dots.d_radius){
            ctx.beginPath();
            ctx.strokeStyle = averageColorStyles(i_dot, j_dot); //计算填充颜色
            ctx.moveTo(i_dot.x, i_dot.y); //连线的起点坐标
            ctx.lineTo(j_dot.x, j_dot.y); //连线的终点坐标
            ctx.stroke();  //填充线条
            ctx.closePath();
          }
        }
      }
    }
  }

  function drawDots() {
    for(i = 0; i < dots.nb; i++){
      var dot = dots.array[i];
      dot.draw();
    }
  }

  function animateDots() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);  //清除窗口内像素
    moveDots();
    connectDots();
    drawDots();
    requestAnimationFrame(animateDots); //递归
  }

  //获取鼠标位置
  $('canvas').on('mousemove', function(e){
    mousePosition.x = e.pageX;
    mousePosition.y = e.pageY;
  });

  $('canvas').on('mouseleave', function(e){
    mousePosition.x = canvas.width / 2;
    mousePosition.y = canvas.height / 2;
  });

  createDots();
  requestAnimationFrame(animateDots); //帧动画API
}

function tryConvert(value) {
  var input = parseInt(value);
  if (Number.isNaN(input)) {
    return null;
  }
  if(input < 0) {
    return 0;
  }
  if(input > 800) {
    return 800;
  }
  return input;
}


document.body.style.backgroundColor = 'rgb(240, 240, 230)';

render(350);

window.wallpaperPropertyListener = {
  applyUserProperties: function(properties) {
    if (properties.customtext) {
      var dotsCount = tryConvert(properties.customtext.value);
      if(dotsCount !== null){
        render(dotsCount);
      }
    }
    if (properties.customcolor) {
      var customColor = properties.customcolor.value.split(' ');
      customColor = customColor.map(function(c) {
          return Math.ceil(c * 255);
      });
      var customColorAsCSS = 'rgb(' + customColor + ')';
      document.body.style.backgroundColor = customColorAsCSS;
    }
  }
};
