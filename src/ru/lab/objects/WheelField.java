package ru.lab.objects;

public enum WheelField {
    ZERO(0, "GREEN", "NONE"),
    SECTOR_1(1, "RED", "ODD"),
    SECTOR_3(3, "RED", "ODD"),
    SECTOR_5(5, "RED", "ODD"),
    SECTOR_7(7, "RED", "ODD"),
    SECTOR_9(9, "RED", "ODD"),
    SECTOR_12(12, "RED", "EVEN"),
    SECTOR_14(14, "RED", "EVEN"),
    SECTOR_16(16, "RED", "EVEN"),
    SECTOR_18(18, "RED", "EVEN"),
    SECTOR_19(19, "RED", "ODD"),
    SECTOR_21(21, "RED", "ODD"),
    SECTOR_23(23, "RED", "ODD"),
    SECTOR_25(25, "RED", "ODD"),
    SECTOR_27(27, "RED", "ODD"),
    SECTOR_30(30, "RED", "EVEN"),
    SECTOR_32(32, "RED", "EVEN"),
    SECTOR_34(34, "RED", "EVEN"),
    SECTOR_36(36, "RED", "EVEN"),
    SECTOR_2(2, "BLACK", "EVEN"),
    SECTOR_4(4, "BLACK", "EVEN"),
    SECTOR_6(6, "BLACK", "EVEN"),
    SECTOR_8(8, "BLACK", "EVEN"),
    SECTOR_10(10, "BLACK", "EVEN"),
    SECTOR_11(11, "BLACK", "ODD"),
    SECTOR_13(13, "BLACK", "ODD"),
    SECTOR_15(15, "BLACK", "ODD"),
    SECTOR_17(17, "BLACK", "ODD"),
    SECTOR_20(20, "BLACK", "EVEN"),
    SECTOR_22(22, "BLACK", "EVEN"),
    SECTOR_24(24, "BLACK", "EVEN"),
    SECTOR_26(26, "BLACK", "EVEN"),
    SECTOR_28(28, "BLACK", "EVEN"),
    SECTOR_29(29, "BLACK", "ODD"),
    SECTOR_31(31, "BLACK", "ODD"),
    SECTOR_33(33, "BLACK", "ODD"),
    SECTOR_35(35, "BLACK", "ODD");

    private final int number;
    private final String color;
    private final String parity;

    WheelField(int number, String color, String parity) {
        this.number = number;
        this.color = color;
        this.parity = parity;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public String getParity() {
        return parity;
    }

    @Override
    public String toString() {
        return "WheelField{" +
                "number=" + number +
                ", color='" + color + '\'' +
                ", parity='" + parity + '\'' +
                '}';
    }

}
