package com.leetcode;

public class Fun {

    public static void main(String[] args) {
        int n = 2;
        while (n < 1000) {
            int a = 3 * n + 1;
            while (a < 4 * n) {
                for (int b = 1; b <= n/2; b ++) {

                    int c = n - b;
                    //System.out.printf("Try: %s %s %s%n", a, b, c);
                    Fraction x = new Fraction(a, b + c);
                    Fraction y = new Fraction(b, a + c);
                    Fraction z = new Fraction(c, a + b);

                    x = x.plus(y);
                    x = x.plus(z);
                    //System.out.printf("Res: %s %s %n", x.getA(), x.getB());
                    if (x.getA() == x.getB() * 4) {
                        System.out.printf("Ans: %s %s %s%n", a, b, c);
                        return;
                    }
                }
                a ++;
            }
            n ++;
        }


    }

    static class Fraction {
        int a;
        int b;
        int temp;

        //构造函数并约分
        Fraction(int m, int n) {
            temp = m < n ? m : n;
            while (temp >= 1) {
                if (m % temp == 0 && n % temp == 0) {
                    a = m / temp;
                    b = n / temp;
                    break;
                }
                temp--;
            }
        }//创建新类时总是先进入构造函数

        int getA()//得到分子
        {
            return a;
        }

        int getB()//得到分母
        {
            return b;
        }

        //打印
        void print() {
            if (b == 1) {
                System.out.println(a);
            } else if (a == b) {
                System.out.println("1");
            } else {
                System.out.println(a + "/" + b);
            }
        }

        //分数相加
        Fraction plus(Fraction r)//将自己的分数与r的分数相加，得到新的Fraction对象
        {
            int a1 = a;//第一个分子
            int b1 = b;//第一个分母
            int a2 = r.getA();//第二个分子
            int b2 = r.getB();//第二个分母
            int c = b1 * b2;

            //求最大公约数
            temp = b1 < b2 ? b1 : b2;
            while (temp >= 1) {
                if (b1 % temp == 0 && b2 % temp == 0) {
                    break;
                }
                temp--;
            }
            int beishu = c / temp;
            int fenzi = (beishu / b1 * a1) + (beishu / b2 * a2);

            int x = 0, y = 0;
            temp = fenzi < beishu ? fenzi : beishu;
            while (temp >= 1) {
                if (fenzi % temp == 0 && beishu % temp == 0) {
                    x = fenzi / temp;
                    y = beishu / temp;
                }
                temp--;
            }
            return new Fraction(x, y);
        }

        //自己与r的分数相乘，产生新的Fraction对象
        Fraction multiply(Fraction r) {
            return new Fraction((a * r.getA()), (b * r.getB()));
        }
    }
}
