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
public class danhsachnhacungcap {

    protected nhacungcap[] nhacc;
    private int soluong;
    static kiemtra kt = new kiemtra();

    public danhsachnhacungcap() {
    }

    public danhsachnhacungcap(nhacungcap[] nhacc, int soluong) {
        this.nhacc = nhacc;
        this.soluong = soluong;
    }

    public nhacungcap[] getNhacungcap() {
        return nhacc;
    }

    public void setNhacungcap(nhacungcap[] ncc) {
        this.nhacc = ncc;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            nhacc = (nhacungcap[]) InputStream.readObject();
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

    public void nhap() {
        System.out.println("- Nhập số lượng nhà cung cấp: ");
        soluong = kt.KiemTraNhapSoNguyen();
        nhacc = new nhacungcap[soluong];
        for (int i = 0; i < soluong; i++) {
            System.out.println("");
            System.out.println("- Nhập nhà cung cấp thứ " + (i + 1));
            nhacc[i] = new nhacungcap();
            nhacc[i].nhap();
        }
    }

    public void table() {
        System.out.println("+-----------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách nhà cung cấp\t\t\t\t\t  |");
        System.out.println("+-----------------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-15s|%-20s|%-15s|%-20s|\n", "Mã NhCC", "Tên NhCC", "Địa chỉ", "Điện thoại", "Mail");
        System.out.println("+-----------------------------------------------------------------------------------------+");
    }

    public void footer() {
        System.out.println("+-----------------------------------------------------------------------------------------+");
    }

    public void tim_kiem() throws IOException {
        doc_file("nhacungcap.txt");
        String chon;
        if (nhacc.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+===============================+");
                System.out.println("|            Tìm kiếm           |");
                System.out.println("+===============================+");
                System.out.println("| 1. Theo mã nhà cung cấp       |");
                System.out.println("| 2. Theo tên nhà cung cấp      |");
                System.out.println("| 0. Exit                       |");
                System.out.println("+===============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nhập mã nhà cung cấp cần tìm: ");
                        String manhancungcap = kt.KiemTraNhapMaNhaCungCap();
                        table();
                        for (int i = 0; i < nhacc.length; i++) {
                            if (nhacc[i].getManhacungcap().equals(manhancungcap)) {
                                dem++;
                                nhacc[i].xuatncc();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có nhà cung cấp cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập tên nhà cung cấp cần tìm: ");
                        String tennhacungcap = kt.KiemTraNhapTenSanPham();
                        table();
                        for (int i = 0; i < nhacc.length; i++) {
                            if (nhacc[i].getTennhacungcap().equals(tennhacungcap)) {
                                dem++;
                                nhacc[i].xuatncc();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có nhà cung cấp cần tìm");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
    }

    public nhacungcap[] them() throws IOException {
        int add;
        String chon;
        System.out.println("- Nhập số lượng nhà cung cấp cần thêm: ");
        add = kt.KiemTraNhapSoNguyen();
        doc_file("nhacungcap.txt");
        nhacungcap[] temp = new nhacungcap[nhacc.length + add];
        for (int i = 0; i < nhacc.length; i++) {
            temp[i] = new nhacungcap();
            temp[i] = nhacc[i];
        }
        for (int i = nhacc.length; i < (nhacc.length + add); i++) {
            System.out.println("- Nhập nhà cung cấp thứ: " + (i + 1));
            temp[i] = new nhacungcap();
            temp[i].nhap();

        }
        return temp;
    }

    public void xoa() throws IOException {
        String chon;
        doc_file("nhacungcap.txt");
        int i, j;
        if (nhacc.length < 1) {
            System.out.println("- Danh sách rỗng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+=============================+");
                System.out.println("|        Xóa nhân viên        |");
                System.out.println("+=============================+");
                System.out.println("| 1. Theo mã nhà cung cấp     |");
                System.out.println("| 2. Theo tên nhà cung cấp    |");
                System.out.println("| 0. Exit                     |");
                System.out.println("+=============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String manhacungcap;
                        System.out.println("- Nhập mã nhà cung cấp cần xóa: ");
                        manhacungcap = kt.KiemTraNhapMaNhanVien();
                        nhacungcap[] temp = new nhacungcap[nhacc.length - 1];
                        for (i = j = 0; i < nhacc.length; i++) {
                            if (!nhacc[i].getManhacungcap().equals(manhacungcap)) {
                                temp[j++] = nhacc[i];
                                dem++;
                            }
                        }
                        if (dem == nhacc.length) {
                            System.out.println("- Không có nhà cung cấp cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp, "nhacungcap.txt");
                        break;
                    case "2":
                        String tennhacungcap;
                        System.out.println("- Nhập tên nhà cung cấp cần xóa: ");
                        tennhacungcap = kt.KiemTraNhapTenSanPham();
                        nhacungcap[] temp1 = new nhacungcap[nhacc.length - 1];
                        for (i = j = 0; i < nhacc.length; i++) {
                            if (!nhacc[i].getTennhacungcap().equals(tennhacungcap)) {
                                temp1[j++] = nhacc[i];
                                dem++;
                            }
                        }
                        if (dem == nhacc.length) {
                            System.out.println("- Không có nhà cung cấp cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp1, "nhacungcap.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public nhacungcap[] sua() throws IOException {
        String chon;
        doc_file("nhacungcap.txt");
        if (nhacc.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==============================+");
                System.out.println("|  Sửa thông tin nhà cung cấp  |");
                System.out.println("+==============================+");
                System.out.println("| 1. Theo mã nhà cung cấp      |");
                System.out.println("| 2. Theo tên nhà cung cấp     |");
                System.out.println("| 0. Exit                      |");
                System.out.println("+==============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String manhacungcap;
                        System.out.println("- Nhập mã nhà cung cấp cần sửa: ");
                        manhacungcap = kt.KiemTraNhapMaNhanVien();
                        for (int i = 0; i < nhacc.length; i++) {
                            if (nhacc[i].getManhacungcap().equals(manhacungcap)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Địa chỉ                    |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = kt.KiemTraNhapChuoi();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        nhacc[i].setDiachi(nhacc[i].getDiachi());
                                        break;
                                    case "2":
                                        nhacc[i].setDienthoai(nhacc[i].getDienthoai());
                                        break;
                                    case "3":
                                        nhacc[i].setMail(nhacc[i].getMail());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }

                        if (dem == 0) {
                            System.out.println("- Tìm không thấy nhà cung cấp!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                        file.ghi_file(nhacc, "nhacungcap.txt");
                        break;
                    case "2":
                        String tennhacungcap;
                        System.out.println("- Nhập tên nhà cung cấp cần sửa: ");
                        tennhacungcap = kt.KiemTraNhapTenSanPham();
                        for (int i = 0; i < nhacc.length; i++) {
                            if (nhacc[i].getTennhacungcap().equals(tennhacungcap)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Địa chỉ                    |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = kt.KiemTraNhapChuoi();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        nhacc[i].setDiachi(nhacc[i].getDiachi());
                                        break;
                                    case "2":
                                        nhacc[i].setDienthoai(nhacc[i].getDienthoai());
                                        break;
                                    case "3":
                                        nhacc[i].setMail(nhacc[i].getMail());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Tìm không thấy nhà cung cấp!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                        file.ghi_file(nhacc, "nhacungcap.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
        return nhacc;
    }

    public void HienThi() throws IOException {
        doc_file("nhacungcap.txt");
        table();
        for (int i = 0; i < nhacc.length; i++) {
            nhacc[i].xuatncc();
        }
        footer();
    }

    public void menu() throws IOException {
        String chonn;
        do {
            System.out.println("");
            System.out.println("+==================================+");
            System.out.println("|       Quản lí nhà cung cấp       |");
            System.out.println("+==================================+");
            System.out.println("| 1. Thêm nhà cung cấp             |");
            System.out.println("| 2. Xuất thông tin nhà cung cấp   |");
            System.out.println("| 3. Xóa nhà cung cấp              |");
            System.out.println("| 4. Sửa thông tin nhà cung cấp    |");
            System.out.println("| 5. Tim kiếm nhà cung cấp         |");
            System.out.println("| 6. Nhập mới danh sách            |");
            System.out.println("| 0. Exit                          |");
            System.out.println("+==================================+");
            System.out.println("- Bạn hãy nhập lựa chọn: ");
            chonn = kt.KiemTraNhapChuoi();
            switch (chonn) {
                case "0":
                    break;
                case "1":
                    nhacc = them();
                    file.ghi_file(nhacc, "nhacungcap.txt");
                    break;
                case "2":
                    HienThi();
                    break;
                case "3":
                    xoa();
                    break;
                case "4":
                    nhacc = sua();
                    break;
                case "5":
                    tim_kiem();
                    break;
                case "6":
                    nhap();
                    file.ghi_file(nhacc, "nhacungcap.txt");
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                    break;
            }
        } while (!chonn.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachnhacungcap nhcc = new danhsachnhacungcap();
        nhcc.menu();
    }
}
