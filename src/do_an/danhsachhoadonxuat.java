/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author PC
 */
public class danhsachhoadonxuat extends danhsachnhanvien {

    protected hoadonxuat[] hdx;
    private int soluong;
    protected khachhang[] kh;

    public danhsachhoadonxuat() {
        hdx = null;
        soluong = 0;
    }

    public danhsachhoadonxuat(hoadonxuat[] hdx, int soluong) {
        this.hdx = hdx;
        this.soluong = soluong;
    }

    public hoadonxuat[] getHdx() {
        return hdx;
    }

    public void setHdx(hoadonxuat[] hdx) {
        this.hdx = hdx;
    }

    @Override
    public int getSoluong() {
        return soluong;
    }

    @Override
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            hdx = (hoadonxuat[]) InputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (InputStream != null) {
                InputStream.close();
            }
        }
    }
    
    public void doc_file_kh(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            kh = (khachhang[]) InputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (InputStream != null) {
                InputStream.close();
            }
        }
    }

    @Override
    public void table() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh s??ch s???n ph???m\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "M?? HD", "M?? KH", "M?? NV", "Ng??y xu???t", "T???ng ti???n");
        System.out.println("+-------------------------------------------------------------------------------+");

    }

    @Override
    public void footer() {
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    public void nhaphoadon() throws IOException {
        System.out.println("- Nh???p h??a ????n: ");
        hdx = new hoadonxuat[1];
        kh = new khachhang[1];
        for (int i = 0; i < 1; i++) {
            hdx[i] = new hoadonxuat();
            kh[i]=new khachhang();
            hdx[i].nhap();
            System.out.println("- Nh???p th??ng tin kh??ch h??ng");
            kh[i].nhapkh();
            kh[i].ngaymua=hdx[i].ngayxuat;
            kh[i].makh=hdx[i].kh.getmakh();
        }
    }

    public hoadonxuat[] them1() throws IOException {
        doc_file("hoadonxuat.txt");
        doc_file_kh("khachhang.txt");
        hoadonxuat[] temp = new hoadonxuat[hdx.length + 1];
        khachhang[] tempkh=new khachhang[kh.length+1];
        for (int i = 0; i < hdx.length; i++) {
            temp[i] = new hoadonxuat();
            temp[i] = hdx[i];
            tempkh[i]=kh[i];
        }
        for (int i = hdx.length; i < (hdx.length + 1); i++) {
            System.out.println("- Nh???p h??a ????n th???: " + (i + 1));
            temp[i] = new hoadonxuat();
            tempkh[i]=new khachhang();
            temp[i].nhap();
            tempkh[i].nhapkh();
            tempkh[i].ngaymua=temp[i].ngayxuat;
            tempkh[i].makh=temp[i].kh.getmakh();
        }
        file.ghi_file(tempkh,"khachhang.txt");
        return temp;
    }

    @Override
    public void xoa() throws IOException {
        doc_file("hoadonxuat.txt");
        int i, j;
        if (hdx.length < 1) {
            System.out.println("- Danh s??ch r???ng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+===========================+");
                System.out.println("|        X??a h??a ????n        |");
                System.out.println("+===========================+");
                System.out.println("| 1. Theo m?? h??a ????n        |");
                System.out.println("| 2. Theo m?? kh??ch h??ng     |");
                System.out.println("| 0. Exit                   |");
                System.out.println("+===========================+");
                System.out.println("- B???n h??y nh???p l???a ch???n: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String mahoadon;
                        System.out.println("- Nh???p m?? h??a ????n: ");
                        mahoadon = kt.KiemTraNhapMaHoaDon();
                        hoadonxuat[] temp = new hoadonxuat[hdx.length - 1];
                        for (i = j = 0; i < hdx.length; i++) {
                            if (!hdx[i].getMahoadon().equals(mahoadon)) {
                                temp[j++] = hdx[i];
                                dem++;
                            }
                        }
                        if (dem == hdx.length) {
                            System.out.println("- Kh??ng h??a ????n c???n x??a");
                        } else {
                            System.out.println("- X??a th??nh c??ng.");
                        }
                        file.ghi_file(temp, "hoadonxuat.txt");
                        break;
                    case "2":
                        String makhachhang;
                        System.out.println("- Nh???p m?? kh??ch h??ng: ");
                        makhachhang = kt.KiemTraNhapMaKhachHang();
                        hoadonxuat[] temp1 = new hoadonxuat[hdx.length - 1];
                        for (i = j = 0; i < hdx.length; i++) {
                            if (!hdx[i].getKh().makh.equals(makhachhang)) {
                                temp1[j++] = hdx[i];
                                dem++;
                            }
                        }
                        if (dem == hdx.length) {
                            System.out.println("- Kh??ng c?? h??a ????n c???n x??a");
                        } else {
                            System.out.println("- X??a th??nh c??ng.");
                        }
                        file.ghi_file(temp1, "hoadonxuat.txt");
                        break;
                    default:
                        System.out.println("- L???a ch???n kh??ng h???p l???! M???i nh???p l???i.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public void TimKiem() throws IOException {
        doc_file("hoadonxuat.txt");
        if (hdx.length < 1) {
            System.out.println("- Danh s??ch r???ng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==========================+");
                System.out.println("|         T??m ki???m         |");
                System.out.println("+==========================+");
                System.out.println("| 1. Theo m?? h??a ????n       |");
                System.out.println("| 2. Theo m?? nh??n vi??n     |");
                System.out.println("| 3. Theo m?? kh??ch h??ng    |");
                System.out.println("| 4. Theo ng??y             |");
                System.out.println("| 0. Exit                  |");
                System.out.println("+==========================+");
                System.out.println("- B???n h??y l???a ch???n: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nh???p m?? h??a ????n c???n t??m: ");
                        String mahoadon = kt.KiemTraNhapMaHoaDon();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getMahoadon().equals(mahoadon)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Kh??ng c?? h??a ????n c???n t??m");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nh???p t??n m?? nh??n vi??n: ");
                        String manhanvien = kt.KiemTraNhapMaNhanVien();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getNvbh().manv.equals(manhanvien)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Kh??ng c?? h??a ????n c???n t??m");
                        }
                        footer();
                        break;
                    case "3":
                        System.out.println("- Nh???p m?? kh??ch h??ng: ");
                        String makhachhang = kt.KiemTraNhapMaKhachHang();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getKh().makh.equals(makhachhang)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Kh??ng c?? h??a ????n c???n t??m");
                        }
                        footer();
                        break;
                    case "4":
                        System.out.println("- Nh???p ng??y c???n t??m: ");
                        String ngay = kt.KiemTraNhapChuoi();
                        table();
                        for (int i = 0; i < hdx.length; i++) {
                            if (hdx[i].getNgayxuat().equals(ngay)) {
                                dem++;
                                hdx[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Kh??ng c?? h??a ????n c???n t??m");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- L???a ch???n kh??ng h???p l???! M???i nh???p l???i.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public void XuatNhanVienBan() throws IOException {
        int dem = 0;
        doc_file("hoadonxuat.txt");
        super.doc_file("objnhanvien.txt");
        String ngayban;
        System.out.println("- Nh???p ng??y b??n");
        ngayban = sc.nextLine();
        super.table();
        for (int i = 0; i < hdx.length; i++) {
            if (hdx[i].getNgayxuat().equals(ngayban)) {
                dem++;
                for (int j = 0; j < super.nv.length; j++) {
                    if (super.nv[j].getmanv().equals(hdx[i].getNvbh().manv) && super.nv[j].getChucvu().equals("B??n h??ng")) {
                        super.nv[j].HienThi();
                    }
                }
            }
        }
        if (dem == 0) {
            System.out.println("- Kh??ng tim th???y h??a ????n.");
        }
        super.footer();
    }

    @Override
    public void HienThi() throws IOException {
        int dem = 0;
        doc_file("hoadonxuat.txt");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh s??ch s???n ph???m\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "M?? HD", "M?? KH", "M?? NV", "Ng??y xu???t", "T???ng ti???n");
        System.out.println("+-------------------------------------------------------------------------------+");
        for (int i = 0; i < hdx.length; i++) {
            hdx[i].HienThi();
            dem++;
        }
        if (dem == 0) {
            System.out.println("|\t\t\t\tDanh s??ch r???ng!\t\t\t\t\t|");
        }
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    @Override
    public void menu() throws IOException {
        String chon1;
        do {
            System.out.println("");
            System.out.println("+=======================+");
            System.out.println("|          MENU         |");
            System.out.println("+=======================+");
            System.out.println("| 1. Nh???p m???i           |");
            System.out.println("| 2. Xu???t               |");
            System.out.println("| 3. Th??m               |");
            System.out.println("| 4. X??a                |");
            System.out.println("| 5. T??m ki???m           |");
            System.out.println("| 6. Xu???t nh??n vi??n b??n |");
            System.out.println("| 0. K???t th??c           |");
            System.out.println("+=======================+");
            System.out.println("- Nh???p l???a chon: ");
            chon1 = kt.KiemTraNhapChuoi();
            switch (chon1) {
                case "0":
                    break;
                case "1":
                    nhaphoadon();
                    file.ghi_file(hdx, "hoadonxuat.txt");
                    file.ghi_file(kh, "khachhang.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    hdx = them1();
                    file.ghi_file(hdx, "hoadonxuat.txt");
                    break;
                case "4":
                    xoa();
                    break;
                case "5":
                    TimKiem();
                    break;
                case "6":
                    XuatNhanVienBan();
                    break;
                default:
                    System.out.println("- L???a ch???n kh??ng h???p l???.");
            }
        } while (!chon1.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachhoadonxuat dshd = new danhsachhoadonxuat();
        dshd.menu();
    }
}
