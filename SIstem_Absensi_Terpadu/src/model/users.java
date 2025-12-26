/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user
 */
public class users {
    private static int idUser;
    private static String username;
    private static String password;
    private static String role;
    private static boolean isActive;

    public users(int idUser,String username,String password, String role, boolean isActive) {
        this.idUser=idUser;
        this.username=username;
        this.password=password;
        this.role=role;
        this.isActive=isActive;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        users.idUser = idUser;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        users.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        users.password = password;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        users.role = role;
    }

    public static boolean isIsActive() {
        return isActive;
    }

    public static void setIsActive(boolean isActive) {
        users.isActive = isActive;
    }

    public users() {
    }
    
}
