import java.util.Scanner;
import java.util.regex.Pattern;

public class CharactersManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String characters = "";
        do {
            System.out.println("***************************** MENU *****************************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số, đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi (xóa khoảng trắng dư thừa, viết hoa chữ cái đầu)");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhap chuoi bat ky: ");
                    characters = sc.nextLine();
                    System.out.println("Chuoi da nhap la: " + characters);
                    break;

                case 2:
                    String numberRegex = "[0-9]";
                    String uppercaseRegex = "[A-Z]";
                    String lowercaseRegex = "[a-z]";
                    String specialCharactersRegex = "[!#$%^&*]";
                    int numberCount = 0;
                    int uppercaseCount = 0;
                    int lowercaseCount = 0;
                    int specialCharactersCount = 0;

                    for (int i = 0; i < characters.length(); i++) {
                        String character = Character.toString(characters.charAt(i));
                        if (Pattern.matches(numberRegex, character)) {
                            numberCount++;
                        }
                        if (Pattern.matches(uppercaseRegex, character)) {
                            uppercaseCount++;
                        }
                        if (Pattern.matches(lowercaseRegex, character)) {
                            lowercaseCount++;
                        }
                        if (Pattern.matches(specialCharactersRegex, character)) {
                            specialCharactersCount++;
                        }
                    }

                    System.out.println("So ki tu la number: " + numberCount);
                    System.out.println("So ki tu thuong: " + lowercaseCount);
                    System.out.println("So ki tu viet hoa: " + uppercaseCount);
                    System.out.println("So ki tu dac biet: " + specialCharactersCount);
                    break;

                case 3:
                    char[] characterArray = characters.toCharArray();
                    StringBuilder reverseCharacters = new StringBuilder();
                    for (int i = characterArray.length - 1; i >= 0; i--) {
                        reverseCharacters.append(characterArray[i]);
                    }
                    characters = reverseCharacters.toString();
                    System.out.println("Chuoi sau khi dao cac phan tu la: " + characters);
                    break;

                case 4:
                    char[] characterArray2 = characters.toCharArray();
                    boolean isPalindrome = true;
                    for (int i = 0; i < characterArray2.length / 2; i++) {
                        if (characterArray2[i] != characterArray2[characterArray2.length - i - 1]) {
                            isPalindrome = false;
                            break;
                        }
                    }

                    if (isPalindrome) {
                        System.out.println("Day la chuoi Palindrome");
                    } else {
                        System.out.println("Day khong phai la chuoi Palindrome");
                    }
                    break;

                case 5:
                    String normalizedString  = characters.trim().toLowerCase().replaceAll("\\s+", " ");
                    String [] normalizedArray = normalizedString.split(" ");
                    StringBuilder normalizedCharacters = new StringBuilder();
                    for (int i = 0; i < normalizedArray.length; i++) {
                        normalizedCharacters.append(Character.toUpperCase(normalizedArray[i].charAt(0))).append(normalizedArray[i].substring(1)).append(" ");
                    }
                    System.out.println("Chuoi sau khi chuan hoa la: " + normalizedCharacters.toString().trim());
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui long nhap so tu 1-6");
            }
        } while (true);
    }
}
