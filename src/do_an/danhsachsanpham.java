
package do_an;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class danhsachsanpham {

    protected sanpham[] sp;
    kiemtra kt = new kiemtra();
    static Scanner sc = new Scanner(System.in);
    static String chon = null;

    public danhsachsanpham() {
    }

    public danhsachsanpham(sanpham[] sp) {
        this.sp = sp;
    }

    public sanpham[] getSp() {
        return sp;
    }

    public void setSp(sanpham[] sp) {
        this.sp = sp;
    }

    public kiemtra getKt() {
        return kt;
    }

    public void setKt(kiemtra kt) {
        this.kt = kt;
    }

    public static String getChon() {
        return chon;
    }

    public static void setChon(String chon) {
        danhsachsanpham.chon = chon;
    }

    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            sp = (sanpham[]) InputStream.readObject();
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

    public void Nhap() {
        int soluong;
        System.out.println("");
        System.out.println("- Nhập số lượng sản phẩm: ");
        soluong = kt.KiemTraNhapSoNguyen();
        sp = new sanpham[soluong];
        for (int i = 0; i < soluong; i++) {
            System.out.println("");
            System.out.println("+========================+");
            System.out.println("|          Loại          |");
            System.out.println("+========================+");
            System.out.println("| 1. Thức ăn             |");
            System.out.println("| 2. Nước giải khát      |");
            System.out.println("+========================+");
            System.out.println("- Bạn hãy lựa chon: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.println("- Nhập sản phẩm thứ: " + (i + 1));
                    sp[i] = new thucan();
                    sp[i].nhap();
                    break;
                case "2":
                    System.out.println("- Nhập sản phẩm thứ: " + (i + 1));
                    sp[i] = new nuocgiaikhat();
                    sp[i].nhap();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
            }
        }
    }

    public void HienThi() throws IOException {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-20s|%-10s|%-15s|%-15s|\n", "Mã SP", "Tên SP", "Giá", "Loại", "Số lượng");
        System.out.println("+-------------------------------------------------------------------------------+");
        for (int i = 0; i < sp.length; i++) {
            sp[i].HienThi();
        }
        System.out.println("+-------------------------------------------------------------------------------+");

    }

    public void Loc() throws IOException {
        doc_file("sanpham.txt");
        do {
            System.out.println("");
            System.out.println("+=========================+");
            System.out.println("|           Lọc           |");
            System.out.println("+=========================+");
            System.out.println("| 1. Thức ăn              | ");
            System.out.println("| 2. Nước giải khát       |");
            System.out.println("| 0. Exit                 |");
            System.out.println("+=========================+");
            System.out.println("- Nhập lựa chọn: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.println("+----------------------------------- THỨC ĂN -----------------------------------+");
                    table();
                    for (int i = 0; i < sp.length; i++) {
                        if (sp[i] instanceof thucan) {
                            sp[i] = (thucan) sp[i];
                            sp[i].HienThi();
                        }
                    }
                    footer();
                    break;
                case "2":
                    System.out.println("+------------------------------- NƯỚC GIẢI KHÁT --------------------------------+");
                    table();
                    for (int i = 0; i < sp.length; i++) {
                        if (sp[i] instanceof nuocgiaikhat) {
                            sp[i] = (nuocgiaikhat) sp[i];
                            sp[i].HienThi();
                        }
                    }
                    footer();
                    break;
                default:
                    System.out.println("- Lựa chon không hợp lệ!!!");
            }
        } while (!chon.equals("0"));
    }

    public void table() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.printf("|%-15s|%-20s|%-10s|%-15s|%-15s|\n", "Mã SP", "Tên SP", "Giá", "Loại", "Số lượng");
        System.out.println("+-------------------------------------------------------------------------------+");

    }

    public void footer() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("");
    }

    public void TimKiem() throws IOException {
        doc_file("sanpham.txt");
        if (sp.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==========================+");
                System.out.println("|         Tìm kiếm         |");
                System.out.println("+==========================+");
                System.out.println("| 1. Theo mã sản phẩm      |");
                System.out.println("| 2. Theo tên sản phẩm     |");
                System.out.println("| 0. Exit                  |");
                System.out.println("+==========================+");
                System.out.println("- Bạn hãy lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nhập mã sản phẩm cần tìm: ");
                        String masp = kt.KiemTraNhapMaSanPham();
                        table();
                        for (int i = 0; i < sp.length; i++) {
                            if (sp[i].getMaSP().equals(masp)) {
                                dem++;
                                sp[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có sản phẩm cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập tên sản phẩm cần tìm: ");
                        String tensp = kt.KiemTraNhapTenSanPham();
                        table();
                        for (int i = 0; i < sp.length; i++) {
                            if (sp[i].getTenSP().equals(tensp)) {
                                dem++;
                                sp[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có sản phẩm cần tìm");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public sanpham[] Them() throws IOException {
        int add;
        System.out.println("- Nhập số lượng sản phẩm cần thêm: ");
        add = kt.KiemTraNhapSoNguyen();
        doc_file("sanpham.txt");
        sanpham[] temp = new sanpham[add];
        sanpham[] temp1 = new sanpham[sp.length + add];
        sanpham[] temp2 = new sanpham[sp.length + add];
        for (int i = 0; i < add; i++) {
            System.out.println("+==========================+");
            System.out.println("|           Loại           |");
            System.out.println("+==========================+");
            System.out.println("| 1. Thức ăn               |");
            System.out.println("| 2. Nước giải khát        |");
            System.out.println("+==========================+");
            System.out.println("- Bạn hãy lựa chọn: ");
            chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.println("- Nhập sản phẩm thứ: " + (i + sp.length + 1));
                    temp[i] = new thucan();
                    temp[i].nhap();
                    break;
                case "2":
                    System.out.println("- Nhập sản phẩm thứ: " + (i + sp.length + 1));
                    temp[i] = new nuocgiaikhat();
                    temp[i].nhap();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
            }
        }
        for (int i = 0; i < sp.length; i++) {
            temp1[i] = new sanpham() {
                @Override
                public void HienThi() {
                }
            };
            temp1[i] = sp[i];
        }
        for (int i = sp.length; i < (sp.length + add); i++) {
            temp1[i] = new sanpham() {
                @Override
                public void HienThi() {
                }
            };

            for (int j = 0; j < sp.length; j++) {
                if (temp[i - sp.length].getTenSP().equals(temp1[j].getTenSP())) {
                    System.out.println("- Sản phẩm " + temp1[j].tenSP + " đã tồn tại. Số lượng sản phẩm đã được thêm vào.");
                    temp1[j].soluong += temp[i - sp.length].getSoluong();
                    temp2 = sp;
                    break;
                } else {
                    temp1[i] = temp[i - sp.length];
                    temp2 = temp1;
                }
            }

        }
        return temp2;
    }

    public void Xoa() throws IOException {
        doc_file("sanpham.txt");
        int i, j;
        if (sp.length < 1) {
            System.out.println("- Danh sách rỗng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==========================+");
                System.out.println("|       Xoa sản phẩm       |");
                System.out.println("+==========================+");
                System.out.println("| 1. Theo mã sản phẩm      |");
                System.out.println("| 2. Theo tên sản phẩm     |");
                System.out.println("| 0. Exit                  |");
                System.out.println("+==========================+");
                System.out.println("- Bạn hãy chọn");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String masp;
                        System.out.println("- Nhập mã sản phẩm cần xóa: ");
                        masp = kt.KiemTraNhapMaSanPham();
                        sanpham[] temp = new sanpham[sp.length - 1];
                        for (i = j = 0; i < sp.length; i++) {
                            if (!sp[i].maSP.equals(masp)) {
                                temp[j++] = sp[i];
                                dem++;
                            }
                        }
                        if (dem == sp.length) {
                            System.out.println("- Không có sản phẩm cần xóa");
                        } else {
                            System.out.println("- Xóa thành công");
                        }
                        file.ghi_file(temp, "sanpham.txt");
                        break;
                    case "2":
                        String tensp;
                        System.out.println("- Nhập tên sản phẩm cần xóa: ");
                        tensp = kt.KiemTraNhapTenSanPham();
                        sanpham[] temp1 = new sanpham[sp.length - 1];
                        for (i = j = 0; i < sp.length; i++) {
                            if (!sp[i].maSP.equals(tensp)) {
                                temp1[j++] = sp[i];
                                dem++;
                            }
                        }
                        if (dem == sp.length) {
                            System.out.println("- Không có sản phẩm cần xóa");
                        } else {
                            System.out.println("- Xóa thành công");
                        }
                        file.ghi_file(temp1, "sanpham.txt");
                        break;

                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public sanpham[] Sua() throws IOException {
        doc_file("sanpham.txt");
        if (sp.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+============================+");
                System.out.println("|        Sửa sản phẩm        |");
                System.out.println("+============================+");
                System.out.println("| 1. Theo mã sản phẩm.       |");
                System.out.println("| 2. Theo tên sản phẩm       |");
                System.out.println("| 0. Exit                    |");
                System.out.println("+============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = sc.nextLine();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String masanpham;
                        System.out.println("- Nhập mã sản phẩm cần sửa: ");
                        masanpham = kt.KiemTraNhapMaSanPham();
                        for (int i = 0; i < sp.length; i++) {
                            if (sp[i].getMaSP().equals(masanpham)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+============================+");
                                System.out.println("|      Thông tin cần sửa     |");
                                System.out.println("+============================+");
                                System.out.println("| 1. Mã sản phẩm             |");
                                System.out.println("| 2. Tên sản phẩm            |");
                                System.out.println("| 3. Giá                     |");
                                System.out.println("| 0. Dung chinh sua          |");
                                System.out.println("+============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = sc.nextLine();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        sp[i].setMaSP(sp[i].getMaSP());
                                        break;
                                    case "2":
                                        sp[i].setTenSP(sp[i].getTenSP());
                                        break;
                                    case "3":
                                        sp[i].setGia(sp[i].getGia());
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
                        file.ghi_file(sp, "sanpham.txt");
                        break;
                    case "2":
                        String tensanpham;
                        System.out.println("- Nhập tên sản phẩm cần sửa: ");
                        tensanpham = kt.KiemTraNhapTenSanPham();
                        for (int i = 0; i < sp.length; i++) {
                            if (sp[i].getTenSP().equals(tensanpham)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+============================+");
                                System.out.println("|      Thông tin cần sửa     |");
                                System.out.println("+============================+");
                                System.out.println("| 1. Mã sản phẩm             |");
                                System.out.println("| 2. Tên sản phẩm            |");
                                System.out.println("| 3. Giá                     |");
                                System.out.println("| 0. Dung chinh sua          |");
                                System.out.println("+============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = sc.nextLine();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        sp[i].setMaSP(sp[i].getMaSP());
                                        break;
                                    case "2":
                                        sp[i].setTenSP(sp[i].getTenSP());
                                        break;
                                    case "3":
                                        sp[i].setGia(sp[i].getGia());
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
                            System.out.println("- Sửa thành công");
                        }
                        file.ghi_file(sp, "sanpham.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
        return sp;
    }

    public void menu() throws IOException {
        doc_file("sanpham.txt");
        String chon1;
        do {
            System.out.println("");
            System.out.println("+================================+");
            System.out.println("|        Quản lí sản phẩm        |");
            System.out.println("+================================+");
            System.out.println("| 1. Thêm sản phẩm               |");
            System.out.println("| 2. Xuất thông tin sản phẩm     |");
            System.out.println("| 3. Xóa sản phẩm                |");
            System.out.println("| 4. Sửa thông tin sản phẩm      |");
            System.out.println("| 5. Tim kiếm                    |");
            System.out.println("| 6. Nhập mới danh sách          |");
            System.out.println("| 7. Lọc theo loại sản phẩm      |");
            System.out.println("| 0. Exit                        |");
            System.out.println("+================================+");
            System.out.println("- Bạn hãy nhập lựa chon: ");
            chon1 = sc.nextLine();
            switch (chon1) {
                case "0":
                    break;
                case "1":
                    sp = Them();
                    file.ghi_file(sp, "sanpham.txt");
                    break;
                case "2":
                    doc_file("sanpham.txt");
                    HienThi();
                    break;
                case "3":
                    Xoa();
                    break;
                case "4":
                    doc_file("sanpham.txt");
                    sp = Sua();
                    break;
                case "5":
                    doc_file("sanpham.txt");
                    TimKiem();
                    break;
                case "6":
                    Nhap();
                    file.ghi_file(sp, "sanpham.txt");
                    break;
                case "7":
                    doc_file("sanpham.txt");
                    Loc();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
            }
        } while (!chon1.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachsanpham ds = new danhsachsanpham();
        ds.menu();
    }
}
