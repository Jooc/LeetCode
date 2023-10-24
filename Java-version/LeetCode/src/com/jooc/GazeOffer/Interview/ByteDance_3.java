package com.jooc.GazeOffer.Interview;

import java.util.Scanner;

//1
//0 0 0 1 1 1 1.7320508076
public class ByteDance_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            double x0 = in.nextDouble();
            double y0 = in.nextDouble();
            double z0 = in.nextDouble();
            double vx = in.nextDouble();
            double vy = in.nextDouble();
            double vz = in.nextDouble();
            double R = in.nextDouble();

            double a = vx * vx + vy * vy + vz * vz;
            double b = 2 * (x0 * vx + y0 * vy + z0 * vz);
            double c = x0 * x0 + y0 * y0 + z0 * z0 - R * R;

            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println(-1);
            } else {
                double t1 = (-b + Math.sqrt(delta)) / (2 * a);
                double t2 = (-b - Math.sqrt(delta)) / (2 * a);
                if(t1 < 0 && t2 < 0){
                    System.out.println(-1);
                }else{
                    if(t1 < 0){
                        System.out.println(t2);
                    } else if (t2 < 0) {
                        System.out.println(t1);
                    }else{
                        System.out.println(Math.min(t1, t2));
                    }
                }
            }
        }
    }
}
