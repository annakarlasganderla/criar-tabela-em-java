//package main;
import View.MenuView;
import View.ProdutoView;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        ProdutoView produtoView = new ProdutoView();

        MenuView funcaoMenu = new MenuView();

        funcaoMenu.menu();
    }
}
