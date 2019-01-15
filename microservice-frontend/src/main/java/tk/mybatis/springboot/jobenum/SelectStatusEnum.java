package tk.mybatis.springboot.jobenum;
//        JOB_STATUS=0 表示job的默认状态
//        JOB_STATUS=1 表示job的已经完成初始化设置
//        JOB_STATUS=2 表示job的正在处理
//        JOB_STATUS=3 表示job的完成处理
//        JOB_STATUS=4 表示job的已删除

public enum SelectStatusEnum {
     def("默认", -1);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private SelectStatusEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static Integer getName(String name) {
        for (SelectStatusEnum c : SelectStatusEnum.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}