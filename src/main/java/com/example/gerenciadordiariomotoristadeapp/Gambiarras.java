package com.example.gerenciadordiariomotoristadeapp;

import java.util.List;

public class Gambiarras {
	public static void main(String[] args) {
		Integer valorTotal=0;
		List<Integer> inicio= List.of(10000, 10100,10200,10300);
		List<Integer> fim	= List.of(10100,10200,10300, 10400);
		
		for (int i = 0; i < inicio.size(); i++) {
			valorTotal+=(fim.get(i)- inicio.get(i));
			
		}
		System.out.println(valorTotal);
		
		
	}

}
