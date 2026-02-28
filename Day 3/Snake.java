package org.example;
import java.util.Random;
import java.util.Scanner;

public class Snake {

    static final int HEIGHT = 10;
    static final int WIDTH = 20;

    static int[] snakeX = new int[200];
    static int[] snakeY = new int[200];
    static int snakeLength = 3;

    static int foodX, foodY;
    static char direction = 'R'; // U D L R
    static boolean gameOver = false;

    static char[][] board = new char[HEIGHT][WIDTH];

    public static void main(String[] args) {
        initGame();

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            drawBoard();

            System.out.print("Move (W A S D): ");
            char input = sc.next().toUpperCase().charAt(0);
            updateDirection(input);

            moveSnake();
            checkCollision();
        }

        drawBoard();
        System.out.println("GAME OVER!");
        System.out.println("Score: " + (snakeLength - 3));
        sc.close();
    }

    static void initGame() {
        snakeX[0] = 5;
        snakeY[0] = 5;
        snakeX[1] = 5;
        snakeY[1] = 4;
        snakeX[2] = 5;
        snakeY[2] = 3;

        generateFood();
    }

    static void generateFood() {
        Random rand = new Random();
        foodX = rand.nextInt(HEIGHT - 2) + 1;
        foodY = rand.nextInt(WIDTH - 2) + 1;
    }

    static void updateDirection(char input) {
        if (input == 'W' && direction != 'D') direction = 'U';
        if (input == 'S' && direction != 'U') direction = 'D';
        if (input == 'A' && direction != 'R') direction = 'L';
        if (input == 'D' && direction != 'L') direction = 'R';
    }

    static void moveSnake() {
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        switch (direction) {
            case 'U': snakeX[0]--; break;
            case 'D': snakeX[0]++; break;
            case 'L': snakeY[0]--; break;
            case 'R': snakeY[0]++; break;
        }

        if (snakeX[0] == foodX && snakeY[0] == foodY) {
            snakeLength++;
            generateFood();
        }
    }

    static void checkCollision() {
        if (snakeX[0] == 0 || snakeX[0] == HEIGHT - 1 ||
                snakeY[0] == 0 || snakeY[0] == WIDTH - 1) {
            gameOver = true;
        }

        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                gameOver = true;
            }
        }
    }

    static void drawBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = '.';
            }
        }

        for (int i = 0; i < HEIGHT; i++) {
            board[i][0] = '#';
            board[i][WIDTH - 1] = '#';
        }
        for (int j = 0; j < WIDTH; j++) {
            board[0][j] = '#';
            board[HEIGHT - 1][j] = '#';
        }

        board[foodX][foodY] = 'F';

        for (int i = 0; i < snakeLength; i++) {
            board[snakeX[i]][snakeY[i]] = 'S';
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}