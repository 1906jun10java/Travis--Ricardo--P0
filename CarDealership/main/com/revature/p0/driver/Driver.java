package com.revature.p0.driver;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.revature.p0.daoimpl.*;
import com.revature.p0.beans.*;
import com.revature.p0.services.*;

public class Driver {

	public static void main(String[] args) {
		
		MenuOptionsServices menu = new MenuOptionsServices();
		
		menu.welcomeMenu();
		
	}
}
