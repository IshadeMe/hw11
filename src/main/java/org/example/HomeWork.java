package org.example;


import lombok.SneakyThrows;
import org.example.stage1.AVLTree;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу Step из файла contest6_tasks.pdf
     */
    @SneakyThrows
    public void stepDanceValue(InputStream in, OutputStream out) {
        var tree = new AVLTree();
        var bi = new BufferedReader(new InputStreamReader(in));
        var ps = new PrintStream(out);
        var start = Arrays.stream(bi.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        var actionCount = start.get(1);
        var count = start.get(0);
        boolean[] arr = new boolean[count];

        for (int i = 0; i < actionCount; i++) {

            var id = Integer.parseInt(bi.readLine()) - 1;
            arr[id] = !arr[id];
            ps.print(getSum(arr));
            ps.println();
        }

        ps.flush();
    }

    private int getSum(boolean[] booleans) {
        var maxSum = 0;
        var sum = 1;
        for (int i = 0; i < booleans.length - 1; i++) {
            if (booleans[i] ^ booleans[i+1]) {
                sum += 1;
            } else {
                maxSum = Math.max(maxSum, sum);
                sum = 1;
            }
        }
        return Math.max(sum, maxSum);
    }



}
