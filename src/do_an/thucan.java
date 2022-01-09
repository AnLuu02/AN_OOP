/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.Serializable;

public class thucan extends sanpham implements Serializable {

    private String loai = "Thức ăn";

    public thucan() {
    }

    public thucan(String maSP, String tenSP, int gia) {
        super(maSP, tenSP, gia);
    }

    @Override
    public void nhap() {
        super.nhap();
    }

    @Override
    public void HienThi() {// loại = "Thức ăn"
        System.out.printf("|%-15s|%-20s|%-10s|%-15s|%-15s|\n", super.getMaSP(), super.getTenSP(), super.getGia(), loai, getSoluong());
    }

}
