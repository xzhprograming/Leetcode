public enum NumberEnum {

    TWO(2, new char[]{'a', 'b', 'c'}),
    THREE(3, new char[]{'d', 'e', 'f'}),
    FOUR(4, new char[]{'g', 'h', 'i'}),
    FIVE(5, new char[]{'j', 'k', 'l'}),
    SIX(6, new char[]{'m', 'n', 'o'}),
    SEVEN(7, new char[]{'p', 'q', 'r', 's'}),
    EIGHT(8, new char[]{'t', 'u', 'v'}),
    NINE(9, new char[]{'w', 'x', 'y', 'z'});

    private int code;

    private char[] str;

    // 删除无参构造器
    NumberEnum(int code, char[] str) {
        this.code = code;
        this.str = str;
    }

    public int getCode(){
        return code;
    }

    public char[] getStr(){
        return str;
    }

    public NumberEnum findByCode(int code){
        for( NumberEnum numberEnum : NumberEnum.values()){
            if(numberEnum.getCode() == code){
                return numberEnum;
            }
        }
        return null;
    }
}