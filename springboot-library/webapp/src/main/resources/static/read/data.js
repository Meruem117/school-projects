function appendData(){
	var arr=[
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Life',
					name:'svsss'
				},
				{
					cate:'Art',
					name:'svsss'
				}
			]
			
			for(i in arr){
				var tmp="";
				if(i%6==0){
					tmp+="<br>";
				}
				tmp+="<a href='./Read?cate="+arr[i].cate+"'>";
				// tmp+="<a id='r'>";
				tmp+="<div class='dc' id='r'><div class='book'><div class='cover'></div>";
				tmp+="<h3 class='book_name' id='bookname'>"+arr[i].name+"</h3>";
				tmp+="<span class='writer' id='cate'>"+arr[i].cate+"</span>";
				tmp+="</div></div>";
				tmp+="</a>";
				$("#d").append(tmp);
			}

			// $('#r').click(function () {
			// 	// let bookname = document.getElementById("bookname").innerText;
			// 	let cate = document.getElementById("cate").innerText;
			// 	$.ajax({
			// 		async: true,
			// 		type: "GET",
			// 		url: "./Read?cate="+cate,
			// 	})
			// })
}