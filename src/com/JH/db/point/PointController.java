package com.JH.db.point;

import java.util.Scanner;


public class PointController {
	private Scanner sc;
	private PointInput pi;
	private PointDAO pd;
	private PointView pv;
	
	public PointController() {
		sc = new Scanner(System.in);
		pi = new PointInput();
		pd = new PointDAO();
		pv = new PointView();
	}
	
	public void start() throws Exception {
		boolean check = true;
		
		while(true) {
			System.out.println("1. 점수 정보 등록      2. 종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				PointDTO pointDTO = pi.setPoint();
				int result = pd.insert(pointDTO);
				
				String message = "등록실패";
				if(result>0) {
				message = "등록성공";
				}
				pv.view(message);
				break;
			default :
				check = !check;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}
