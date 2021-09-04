/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author jenie
 */
public class Test {

    public static void main(String[] args) {

        String s = "2019-12-19 00:43:35 INFO  read:73 - user: jyq	read	Soonish";
        String[] ss = s.split("\\s+");
        if (ss != null&& ss.length>3) {
                String time = ss[1].substring(0,1);

                System.out.println(time);
            
        }
    }
}
