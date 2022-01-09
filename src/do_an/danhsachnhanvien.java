/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class danhsachnhanvien {

    kiemtra kt = new kiemtra();
    protected nhanvien[] nv;
    private int soluong;
    static Scanner sc = new Scanner(System.in);
    static String chon = null;
    
    public danhsachnhanvien() {
        nv = null;
        soluong = 0;
    }

    public danhsachnhanvien(nhanvien[] nv, int soluong) {
        this.nv = nv;
        this.soluong = soluong;
    }

    public nhanvien[] getNv() {
        return nv;
    }

    public void setNv(nhanvien[] nv) {
        this.nv = nv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void nhapArr() {
        System.out.println("- Nhập số lượng nhân viên: ");
        soluong = kt.KiemTraNhapSoNguyen();
        nv = new nhanvien[soluong];
        for (int i = 0; i < soluong; i++) {
            System.out.println("");
            System.out.println("+===============================+");
            System.out.println("|            Chức vụ            |");
            System.out.println("+===============================+");
            System.out.println("| 1. Nhân viên bán hàng         |");
            System.out.println("| 2. Nhân viên nhập hàng        |");
            System.out.println("+===============================+");
            System.out.println("- Bạn hãy chọn: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    nv[i] = new nhanvienbanhang();
                    nv[i].nhap();
                    break;
                case "2":
                    nv[i] = new nhanviennhaphang();
                    nv[i].nhap();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại");
            }
        }
    }

    public void table() {
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t\t\t\t\tDanh sách nhân viên\t\t\t\t\t\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|\n", "Mã nhân viên", "Ca làm việc", "Chức vụ", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", " Điện thoại", "Email");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void footer() {
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            nv = (nhanvien[]) InputStream.readObject();
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

    public void tim_kiem() throws IOException {
        doc_file("objnhanvien.txt");
        if (nv.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+============================+");
                System.out.println("|          Tìm kiếm          |");
                System.out.println("+============================+");
                System.out.println("| 1. Theo mã nhân viên       |");
                System.out.println("| 2. Theo tên nhân viên      |");
                System.out.println("| 0. Exit                    |");
                System.out.println("+============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nhập mã nhân viên cần tìm: ");
                        String manhanvien = kt.KiemTraNhapMaNhanVien();
                        table();
                        for (int i = 0; i < nv.length; i++) {
                            if (nv[i].getmanv().equals(manhanvien)) {
                                dem++;
                                nv[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có nhân viên cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập tên nhân viên cần tìm: ");
                        String tennhanvien = kt.KiemTraNhapTenSanPham();
                        table();
                        for (int i = 0; i < nv.length; i++) {
                            if (nv[i].gethoten().equals(tennhanvien)) {
                                dem++;
                                nv[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có nhân viên cần tìm");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
    }

    public nhanvien[] them() throws IOException {
        int add;
        System.out.println("- Nhập số lượng nhân viên cần thêm: ");
        add = kt.KiemTraNhapSoNguyen();
        doc_file("objnhanvien.txt");
        nhanvien[] temp = new nhanvien[nv.length + add];
        for (int i = 0; i < nv.length; i++) {
            temp[i] = new nhanvien();
            temp[i] = nv[i];
        }
        for (int i = nv.length; i < (nv.length + add); i++) {
            System.out.println("");
            System.out.println("+============================+");
            System.out.println("|       Thêm nhân viên       |");
            System.out.println("+============================+");
            System.out.println("| 1. Nhân viên nhập hàng     |");
            System.out.println("| 2. Nhân viên bán hàng      |");
            System.out.println("+============================+");
            System.out.println("- Bạn hãy lựa chọn: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.println("- Nhập nhân viên thứ: " + (i + 1));
                    temp[i] = new nhanviennhaphang();
                    temp[i].nhap();
                    break;
                case "2":
                    System.out.println("- Nhập nhân viên thứ: " + (i + 1));
                    temp[i] = new nhanvienbanhang();
                    temp[i].nhap();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
            }
        }
        return temp;
    }

    public void xoa() throws IOException {
        doc_file("objnhanvien.txt");
        int i, j;
        if (nv.length < 1) {
            System.out.println("- Danh sách rỗng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+===========================+");
                System.out.println("|       Xóa nhân viên       |");
                System.out.println("+===========================+");
                System.out.println("| 1. Theo mã nhân viên      |");
                System.out.println("| 2. Theo tên nhân viên     |");
                System.out.println("| 0. Exit                   |");
                System.out.println("+===========================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String manhanvien;
                        System.out.println("- Nhập mã nhân viên cần xóa: ");
                        manhanvien = kt.KiemTraNhapMaNhanVien();
                        nhanvien[] temp = new nhanvien[nv.length - 1];
                        for (i = j = 0; i < nv.length; i++) {
                            if (!nv[i].getmanv().equals(manhanvien)) {
                                temp[j++] = nv[i];
                                dem++;
                            }
                        }
                        if (dem == nv.length) {
                            System.out.println("- Không có nhân viên cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp, "objnhanvien.txt");
                        break;
                    case "2":
                        String tennhanvien;
                        System.out.println("- Nhập tên nhân viên cần xóa: ");
                        tennhanvien = kt.KiemTraNhapTenSanPham();
                        nhanvien[] temp1 = new nhanvien[nv.length - 1];
                        for (i = j = 0; i < nv.length; i++) {
                            if (!nv[i].gethoten().equals(tennhanvien)) {
                                temp1[j++] = nv[i];
                                dem++;
                            }
                        }
                        if (dem == nv.length) {
                            System.out.println("- Không có nhân viên cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp1, "objnhanvien.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public nhanvien[] sua() throws IOException {
        doc_file("objnhanvien.txt");
        if (nv.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+===========================+");
                System.out.println("|  Sửa thông tin nhân viên  |");
                System.out.println("+===========================+");
                System.out.println("| 1. Theo mã nhân viên.     |");
                System.out.println("| 2. Theo tên nhân viên     |");
                System.out.println("| 0. Exit                   |");
                System.out.println("+===========================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String manhanvien;
                        System.out.println("- Nhập mã nhân viên cần sửa: ");
                        manhanvien = kt.KiemTraNhapMaNhanVien();
                        for (int i = 0; i < nv.length; i++) {
                            if (nv[i].getmanv().equals(manhanvien)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Ca làm việc                |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 4. Địa chỉ                    |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = sc.nextLine();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        nv[i].setcalamviec(nv[i].getcalamviec());
                                        break;
                                    case "2":
                                        nv[i].setDienthoai(nv[i].getdienthoai());
                                        break;
                                    case "3":
                                        nv[i].setEmail(nv[i].getemail());
                                        break;
                                    case "4":
                                        nv[i].setDiachi(nv[i].getdiachi());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }

                        if (dem == 0) {
                            System.out.println("- Tìm không thấy nhân viên cần sửa trong danh sách!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                        file.ghi_file(nv, "objnhanvien.txt");
                        break;
                    case "2":
                        String tennhanvien;
                        System.out.println("- Nhập tên nhân viên cần sửa: ");
                        tennhanvien = kt.KiemTraNhapTenSanPham();
                        for (int i = 0; i < nv.length; i++) {
                            if (nv[i].gethoten().equals(tennhanvien)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Ca làm việc                |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 4. Địa chỉ                    |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chon: ");
                                chon = sc.nextLine();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        nv[i].setcalamviec(nv[i].getcalamviec());
                                        break;
                                    case "2":
                                        nv[i].setDienthoai(nv[i].getdienthoai());
                                        break;
                                    case "3":
                                        nv[i].setEmail(nv[i].getemail());
                                        break;
                                    case "4":
                                        nv[i].setDiachi(nv[i].getdiachi());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Tìm không thấy sản phẩm cần sửa trong danh sách!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                        file.ghi_file(nv, "objnhanvien.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
        return nv;
    }

    public void HienThi() throws IOException {
        int dem = 0;
        doc_file("objnhanvien.txt");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t\t\t\t\tDanh sách nhân viên\t\t\t\t\t\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-15s|%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|\n", "Mã nhân viên", "Ca làm việc", "Chức vụ", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", " Điện thoại", "Email");
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < nv.length; i++) {
            nv[i].HienThi();
            dem++;
        }
        if (dem == 0) {
            System.out.println("- Danh sách rỗng...");
        }
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void Loc() throws IOException {
        doc_file("objnhanvien.txt");
        do {
            System.out.println("");
            System.out.println("+=========================+");
            System.out.println("|           Lọc           |");
            System.out.println("+=========================+");
            System.out.println("| 1. Nhân viên bán hàng   | ");
            System.out.println("| 2. Nhân viên nhập hàng  |");
            System.out.println("| 0. Exit                 |");
            System.out.println("+=========================+");
            System.out.println("- Nhập lựa chọn: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    table();
                    for (int i = 0; i < nv.length; i++) {
                        if (nv[i] instanceof nhanvienbanhang) {
                            nv[i] = (nhanvienbanhang) nv[i];
                            nv[i].HienThi();
                        }
                    }
                    footer();
                    break;
                case "2":
                    System.out.println("- Nhân viên nhập hàng");
                    table();
                    for (int i = 0; i < nv.length; i++) {
                        if (nv[i] instanceof nhanviennhaphang) {
                            nv[i] = (nhanviennhaphang) nv[i];
                            nv[i].HienThi();
                        }
                    }
                    footer();
                    break;
                default:
                    System.out.println("- Lựa chon không hợp lệ!!!");
            }
        } while (!chon.equals("0"));
    }

    public void menu() throws IOException {
        String chonn;
        do {
            System.out.println("");
            System.out.println("+===============================+");
            System.out.println("|       Quản lí nhân viên       |");
            System.out.println("+===============================+");
            System.out.println("| 1. Thêm nhân viên             |");
            System.out.println("| 2. Xuất thông tin nhân viên   |");
            System.out.println("| 3. Xóa nhân viên              |");
            System.out.println("| 4. Sửa thông tin nhân viên    |");
            System.out.println("| 5. Tim kiếm nhân viên         |");
            System.out.println("| 6. Nhập mới danh sách         |");
            System.out.println("| 7. Lọc theo chức vụ           |");
            System.out.println("| 0. Exit                       |");
            System.out.println("+===============================+");
            System.out.println("- Bạn hãy nhập lựa chọn: ");
            chonn = sc.nextLine();
            switch (chonn) {
                case "0":
                    break;
                case "1":
                    nv = them();
                    file.ghi_file(nv, "objnhanvien.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    xoa();
                    break;
                case "4":
                    nv = sua();
                    break;
                case "5":
                    tim_kiem();
                    break;
                case "6":
                    nhapArr();
                    file.ghi_file(nv, "objnhanvien.txt");
                    break;
                case "7":
                    Loc();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                    break;
            }
        } while (!chonn.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachnhanvien ds = new danhsachnhanvien();
        ds.menu();
    }
}
