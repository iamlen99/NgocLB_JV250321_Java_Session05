import java.util.Scanner;

public class VocabManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] englishVocab = new String[100];
        int currentIndex = 0;
        do {
            System.out.println("======= QUẢN LÝ TỪ VỰNG TIẾNG ANH =======");
            System.out.println("1. Thêm từ mới");
            System.out.println("2. Hiển thị danh sách từ vựng");
            System.out.println("3. Sửa từ vựng theo vị trí");
            System.out.println("4. Xóa từ vựng theo vị trí");
            System.out.println("5. Tìm từ chứa ký tự người dùng nhập vào");
            System.out.println("6. Đếm số từ bắt đầu bằng chữ cái người dùng nhập vào");
            System.out.println("7. Sắp xếp danh sách từ theo thứ tự A-Z");
            System.out.println("8. Thoát");
            System.out.println("=========================================");
            System.out.println("Chọn:");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap tu vung muon them: ");
                    englishVocab[currentIndex] = sc.nextLine();
                    currentIndex++;
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Danh sach tu vung: ");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d. %s", i+1, englishVocab[i]);
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.printf("Nhap vi tri ban muon sua tu vung: ");
                    int updateIndex = Integer.parseInt(sc.nextLine());
                    if (updateIndex < 1 || updateIndex > currentIndex) {
                        System.out.println("Vi tri ban nhap khong hop le");
                    } else {
                        System.out.println("Nhap tu vung moi:");
                        String updateVocab = sc.nextLine();
                        englishVocab[updateIndex - 1] = updateVocab;
                        System.out.println("Da sua thanh cong!");
                    }
                    break;

                case 4:
                    System.out.printf("Nhap vi tri ban muon xoa tu vung: ");
                    int deleteIndex = Integer.parseInt(sc.nextLine());
                    if (deleteIndex < 1 || deleteIndex > currentIndex) {
                        System.out.println("Vi tri ban nhap khong hop le");
                    } else {
                        for (int i = 0; i < currentIndex - 1; i++) {
                            if (i >= (deleteIndex - 1)) {
                                englishVocab[i] = englishVocab[i + 1];
                            }
                        }
                        englishVocab[currentIndex - 1] = null;
                        currentIndex--;
                        System.out.println("Da xoa thanh cong!");
                    }
                    break;

                case 5:
                    System.out.print("Nhap ki tu trong tu ma ban muon tim: ");
                    String character = sc.nextLine().trim().toLowerCase();
                    if (character.length() != 1) {
                        System.out.println("Chi duoc nhap 1 ki tu");
                        return;
                    }

                    boolean found = false;
                    for (int i = 0; i < currentIndex; i++) {
                        if (englishVocab[i].toLowerCase().contains(character)) {
                            System.out.printf("Tim thay tu vung co ki tu \"%s\" la: %s\n", character, englishVocab[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.printf("Khong tim thay tu vung co ki tu \"%s\"\n", character);
                    }
                    break;

                case 6:
                    System.out.print("Nhap chu cai bat dau cua tu vung: ");
                    String character2 = sc.nextLine().trim().toLowerCase();
                    if (character2.length() != 1) {
                        System.out.println("Chi duoc nhap 1 ki tu");
                        return;
                    }

                    int wordCount = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (englishVocab[i].toLowerCase().startsWith(character2)) {
                            wordCount++;
                        }
                    }
                    if (wordCount == 0) {
                        System.out.printf("Khong co tu vung nao bat dau bang \"%s\"\n", character2);
                    } else {
                        System.out.printf("Co %d tu vung bat dau bang \"%s\"\n", wordCount, character2);
                    }
                    break;

                case 7:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (englishVocab[i].compareToIgnoreCase(englishVocab[j]) > 0) {
                                String temp = englishVocab[i];
                                englishVocab[i] = englishVocab[j];
                                englishVocab[j] = temp;
                            }
                        }
                    }
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui long chon so tu 1-8");
            }
        } while (true);
    }
}
