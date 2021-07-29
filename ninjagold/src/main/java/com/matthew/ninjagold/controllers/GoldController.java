package com.matthew.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@GetMapping("/")
	public String gold(HttpSession session, Model viewModel) {
		ArrayList<String> activityList = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 50);
		}
		if(session.getAttribute("activities") == null) {
			session.setAttribute("activities", activityList);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activities", session.getAttribute("activities"));
		return "gold.jsp";
	}
	
	@PostMapping("/getGold")
	public String getGold(HttpSession session, @RequestParam("building") String building) {
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activities");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		System.out.println(now);
		Random r = new Random();
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn;
		if(building.equals("farm")) {
			// Do Farm Stuff
			goldThisTurn = r.nextInt((20 - 10) + 1) + 10;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatter.format(now)));
		} else if(building.equals("cave")) {
			// Do Cave Stuff
			goldThisTurn = r.nextInt((10 - 5) + 1) + 5;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatter.format(now)));
		} else if(building.equals("house")) {
			// do House Stuff
			goldThisTurn = r.nextInt((5- 2) + 1) + 2;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatter.format(now)));
		} else if(building.equals("casino")) {
			// Do Casino Stuff
			goldThisTurn = r.nextInt((50 + 50) + 1) + -50;
			if(goldThisTurn > 0) {
				activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatter.format(now)));
			} else {
				activity.add(String.format("You entered a %s and lost %d gold. Ouch! %s \n", building, goldThisTurn, formatter.format(now)));
			}
			
		} else {
			return "redirect:/";
		}
		
		color.equals("Pink")? System.out.println("Pink") : System.out.println("Not Pink");
		
		if(color.equals("pink")) {
			System.out.println("PINK");
		} else {
			System.out.println("Not Pink");
		}
		
		int totalGold = gold += goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activities", activity);
		return "redirect:/";
	}
}
