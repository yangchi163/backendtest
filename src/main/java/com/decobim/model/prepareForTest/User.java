package com.decobim.model.prepareForTest;

/**
 * Created by Administrator on 2017/8/8.
 */
public class User {
    private String userName;
    private String userPwd;
    private String errorPwd;
    private String name;
    private String type;
    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static User user5;
    private static User user6;
    private static User user7;
    private static User user8;
    private static User user9;
    private static User user10;
    private static User user11;
    private static User user12;
    private static User user13;
    private static User user14;
    private static User user15;
    private static User user16;
    private static User user17;
    private static User user18;
    private static User user19;
    private static User user20;
    private static User user21;
    private static User user22;
    private static User user23;
    private static User user24;
    private static User user25;
    private static User user26;
    private static User user27;
    private static User user28;
    private static User user29;
    private static User user30;
    private static User user31;
    private static User user33;//给role使用
    private static User user32;
    private static User user34;
    private static User user35;
    private static User user36;
    private static User user37;
    private static User user100;
    private static User user101;
    private static User user102;
    private static User yc;
    private static User ycTest;

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getErrorPwd() {
        return errorPwd;
    }

    public String getName() {
        return name;
    }
    public String getType(){
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    private User(String userName,String userPwd,String errorPwd,String name){
        this.userName = userName;
        this.userPwd = userPwd;
        this.errorPwd = errorPwd;
        this.name = name;
    }

    public static User user1(){
        if (user1 == null){
            user1 = new User("15000000001", "qqq001", "100qqq","15000000001");
        }
        return user1;
    }
    public static User user2(){
        if (user2 == null) {
            user2 = new User("15000000002", "qqq002", "200qqq","15000000002");
        }
        return user2;
    }
    public static User user3(){
        if (user3 == null) {
            user3 = new User("15000000003", "qqq003", "300qqq","15000000003");
        }
        return user3;
    }
    public static User user4(){
        if (user4 == null) {
            user4 = new User("15000000004", "qqq004", "400qqq","15000000004");
        }
        return user4;
    }
    public static User user5(){
        if (user5 == null) {
            user5 = new User("15000000005", "qqq005", "500qqq","15000000005");
        }
        return user5;
    }
    public static User user6(){
        if (user6 == null) {
            user6 = new User("15000000006", "qqq006", "600qqq","15000000006");
        }
        return user6;
    }
    public static User user7(){
        if (user7 == null) {
            user7 = new User("15000000007", "qqq007", "700qqq","15000000007");
        }
        return user7;
    }
    public static User user8(){
        if (user8 == null) {
            user8 = new User("15000000008", "qqq008", "800qqq","15000000008");
        }
        return user8;
    }
    public static User user9(){
        if (user9 == null) {
            user9 = new User("15000000009", "qqq009", "900qqq","15000000009");
        }
        return user9;
    }
    public static User user10(){
        if (user10 == null) {
            user10 = new User("15000000010", "qqq010", "010qqq","15000000010");
        }
        return user10;
    }
    public static User user11(){
        if (user11 == null) {
            user11 = new User("15000000011", "qqq011", "110qqq","15000000011");
        }
        return user11;
    }
    public static User user12(){
        if (user12 == null) {
            user12 = new User("15000000012", "qqq012", "210qqq","15000000012");
        }
        return user12;
    }
    public static User user13(){
        if (user13 == null) {
            user13 = new User("15000000013", "qqq013", "310qqq","15000000013");
        }
        return user13;
    }
    public static User user14(){
        if (user14 == null) {
            user14 = new User("15000000014", "qqq014", "410qqq","15000000014");
        }
        return user14;
    }
    public static User user15(){
        if (user15 == null) {
            user15 = new User("15000000015", "qqq015", "510qqq","15000000015");
        }
        return user15;
    }
    public static User user16(){
        if (user16 == null) {
            user16 = new User("15000000016", "qqq016", "610qqq","15000000016");
        }
        return user16;
    }
    public static User user17(){
        if (user17 == null) {
            user17 = new User("15000000017", "qqq017", "710qqq","15000000017");
        }
        return user17;
    }
    public static User user18(){
        if (user18 == null) {
            user18 = new User("15000000018", "qqq018", "810qqq","15000000018");
        }
        return user18;
    }
    public static User user19(){
        if (user19 == null) {
            user19 = new User("15000000019", "qqq019", "910qqq","15000000019");
        }
        return user19;
    }
    public static User user20(){
        if (user20 == null) {
            user20 = new User("15000000020", "qqq020", "020qqq","15000000020");
        }
        return user20;
    }
    public static User user21(){
        if (user21 == null) {
            user21 = new User("15000000021", "qqq021", "120qqq","15000000021");
        }
        return user21;
    }
    public static User user22(){
        if (user22 == null) {
            user22 = new User("15000000022", "qqq022", "220qqq","15000000022");
        }
        return user22;
    }
    public static User user23(){
        if (user23 == null) {
            user23 = new User("15000000023", "qqq023", "320qqq","15000000023");
        }
        return user23;
    }
    public static User user24(){
        if (user24 == null) {
            user24 = new User("15000000024", "qqq024", "420qqq","15000000024");
        }
        return user24;
    }
    public static User user25(){
        if (user25 == null) {
            user25 = new User("15000000025", "qqq025", "520qqq","15000000025");
        }
        return user25;
    }
    public static User user26(){
        if (user26 == null) {
            user26 = new User("15000000026", "qqq026", "620qqq","15000000026");
        }
        return user26;
    }
    public static User user27(){
        if (user27 == null) {
            user27 = new User("15000000027", "qqq027", "720qqq","15000000027");
        }
        return user27;
    }
    public static User user28(){
        if (user28 == null) {
            user28 = new User("15000000028", "qqq028", "820qqq","15000000028");
        }
        return user28;
    }
    public static User user29(){
        if (user29 == null) {
            user29 = new User("15000000029", "qqq029", "920qqq","15000000029");
        }
        return user29;
    }
    public static User user30(){
        if (user30 == null) {
            user30 = new User("15000000030", "qqq030", "030qqq","15000000030");
        }
        return user30;
    }
    public static User user31(){
        if (user31 == null) {
            user31 = new User("15000000031", "qqq031", "130qqq","15000000031");
        }
        return user31;
    }
    public static User user32(){
        if (user32 == null) {
            user32 = new User("15000000032", "qqq032", "230qqq","15000000032");
        }
        return user32;
    }
    public static User user33(){
        if (user33 == null) {
            user33 = new User("15000000033", "qqq033", "330qqq","15000000033");
        }
        return user33;
    }
    public static User user34(){
        if (user34 == null) {
            user34 = new User("15000000034", "qqq034", "430qqq","15000000034");
        }
        return user34;
    }
    public static User user35(){
        if (user35 == null) {
            user35 = new User("15000000035", "qqq035", "530qqq","15000000035");
        }
        return user35;
    }
    public static User user36(){
        if (user36 == null) {
            user36 = new User("15000000036", "qqq036", "630qqq","15000000036");
        }
        return user36;
    }
    public static User user37(){
        if (user37 == null) {
            user37 = new User("15000000037", "qqq037", "730qqq","15000000037");
        }
        return user37;
    }
    public static User user100(){
        if (user100 == null) {
            user100 = new User("15000000100", "qqq111", "111qqq","15000000100");
        }
        return user100;
    }
    public static User user101(){
        if (user101 == null) {
            user101 = new User("15000000101", "qqq111", "111qqq","15000000101");
        }
        return user101;
    }
    public static User user102(){
        if (user102 == null) {
            user102 = new User("15000000102", "qqq111", "111qqq","15000000102");
        }
        return user102;
    }
    public static User yc(){
        if (yc == null) {
            yc = new User("15021415241", "qqq111", "111qqq","15021415241");
        }
        return yc;
    }public static User ycTest(){
        if (ycTest == null) {
            ycTest = new User("15021415240", "qqq111", "111qqq","15021415240");
        }
        return ycTest;
    }
}
