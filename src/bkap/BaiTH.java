package bkap;

import java.util.Scanner;

public class BaiTH {

	public static void main(String[] args) {
		int i, j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so phan tu mang a: ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap so hang mang b: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap so cot mang b: ");
		int m = Integer.parseInt(sc.nextLine());
		String[] str = new String[x];
		int[][] arrInt = new int[n][m];
		do {
			System.out.println("\n**********************MENU********************");
			System.out.println("1. Nhập giá trị các phần tử mảng a");
			System.out.println("2. Chuẩn hóa chuỗi giá trị các phần tử mảng a");
			System.out.println("3. Hiển thị giá trị các phần tử mảng a");
			System.out.println("4. Nhập giá trị các phần tử mảng b");
			System.out.println("5. Hiển thị giá trị các phần tử mảng b theo ma trận");
			System.out.println("6. Hiển thị và tính tổng các phần tử mảng b là số nguyên tố");
			System.out.println("6. Hiển thị và tính tổng các phần tử mảng b là số nguyên tố");
			System.out.println("8. In ra dòng có tổng giá trị lớn nhất và nhỏ nhất");
			System.out.println("9. Sắp xếp và hiển thị các dòng trong mảng b tang dần");
			System.out.println("10.Thoát");
			System.out.println("Vui long chon 1 so: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: 
				System.out.println("Nhap cac phan tu mang a: ");
				for(i=0; i<x; i++) {
					System.out.printf("arrInt[%d]: ", i);
					str[i] = sc.nextLine();
				}
				break;
			case 2: 
				System.out.println("Mang sau khi chuan hoa la: ");
				for(i=0; i<x; i++) {
					String temp = "";
					str[i] = str[i].replaceAll("\\s+", " ").trim().toLowerCase();
					String[] arr = str[i].split(" ");
					for(String ss: arr) {
						temp +=String.valueOf(ss.charAt(0)).toUpperCase() + ss.substring(1) + " ";
					}
					str[i]=temp;
					System.out.printf("%s\t", str[i]);
				}
				break;
			case 3:
				for(i=0; i<x; i++) {
					System.out.printf("%s\t", str[i]);
				}
				break;
			case 4:
				for(i=0; i<n; i++) {
					for(j=0; j<m; j++) {
						System.out.printf("arrInt[%d][%d]: ", i, j);
						arrInt[i][j] = Integer.parseInt(sc.nextLine());
					}
				}
				break;
			case 5:
				System.out.println("Cac phan tu trong mang 2 chieu la: ");
				for (i = 0; i < n; i++) {
					for (j = 0; j < m; j++) {
						System.out.printf("%d\t",arrInt[i][j]);
					}
					System.out.printf("\n");
				}
				break;
			case 6:
				System.out.println("Cac so nguyen to trong mang la:  ");
				int sum=0;
				for (i = 0; i < n; i++) {
					for (j = 0; j < m; j++) {
							boolean check = true;
							if (arrInt[i][j]==1) {
								check = false;
							}
							if (arrInt[i][j]>2) {
								for (int t = 2; t <= Math.sqrt(arrInt[i][j]); t++) {
									if (arrInt[i][j]%t==0) {
										check = false;
										break;
									}
								}
							}
							if (check) {
								System.out.printf("%d\t",arrInt[i][j]);
								sum += arrInt[i][j];
							}
					}
				}
				System.out.printf("Tong cac so nguyen to la: %d", sum);
				break;
			case 7:
				if (n==m) {
					int tongChinh = 0, tongPhu = 0;
					System.out.println("Cac phan tu nam tren duong cheo chinh la: ");
					for (i = 0; i < n; i++) {
						for (j = 0; j < m; j++) {
							if (i==j) {
								System.out.printf("%d\t",arrInt[i][j]);
								tongChinh+=arrInt[i][j];
							}
						}						
					}
					System.out.printf("\n");
					System.out.println("Tong gia tri cac phan tu nam tren duong cheo chinh la: "+tongChinh);
					
					System.out.println("Cac phan tu nam tren duong cheo phu la: ");
					for (i = 0; i < n; i++) {
						for (j = 0; j < m; j++) {
							if ((i+j)==(n-1)) {
								System.out.printf("%d\t",arrInt[i][j]);
								tongPhu+=arrInt[i][j];
							}
						}						
					}
					System.out.printf("\n");
					System.out.println("Tong gia tri cac phan tu nam tren duong cheo phu la: "+tongPhu);
				}else {
					System.out.println("Ma tran khong phai ma tran vuong");
				}
				
				break;
			case 8:
				int tongHang = 0;
				int tongMax = arrInt[0][0];
				int dongMax = 0;
				int tongMin = 0;
				int dongMin = 0;
				for(i=0; i<n; i++) {
					tongHang = 0;
					for(j=0; j<m; j++) {
						tongHang += arrInt[i][j];
					}
					if(tongHang>tongMax) {
						tongMax = tongHang;
						dongMax=i;
					}
					tongMin = tongMax;
					dongMin = 0;

					if(tongHang<tongMin) {
						tongMin = tongHang;
						dongMin = i;
					}
				}
				System.out.printf("Dong %d co gia tri lon nhat bang : %d", dongMax, tongMax);
				
				System.out.printf("\nDong %d co gia tri nho nhat bang : %d", dongMin, tongMin);

				break;
			case 9:
				for (i = 0; i < n; i++) {
					for (j = 0; j < m-1; j++) {
						for (int k = j+1; k < m; k++) {
							if (arrInt[i][j]>arrInt[i][k]) {
								int tempp = arrInt[i][j];
								arrInt[i][j] = arrInt[i][k];
								arrInt[i][k] = tempp;
							}
						}
					}
				}
				System.out.println("Da sap xep cac cot tang dan");
				break;
			case 10:
				System.exit(0);
			default:
				System.err.println("Vui long chon tu 1-10: ");
				break;
			}
			
		} while(true);

	}

}
