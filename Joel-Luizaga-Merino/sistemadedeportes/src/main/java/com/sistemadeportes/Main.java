package com.sistemadeportes;

import com.sistemadeportes.vista.FormularioItem;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormularioItem().setVisible(true);
        });
    }
}