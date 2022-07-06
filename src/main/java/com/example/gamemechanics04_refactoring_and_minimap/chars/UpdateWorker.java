package com.example.gamemechanics04_refactoring_and_minimap.chars;

import java.util.ArrayDeque;
import java.util.Queue;

public class UpdateWorker {
    
    public static Direction dir;

    public static void updateWorker() {

        for (int i = 0; i < CreateWorker.worker.size(); i++) {

            if (CreateWorker.worker.get(i).getCx() == CreateWorker.worker.get(i).getMx() && CreateWorker.worker.get(i).getCy() == CreateWorker.worker.get(i).getMy()) {
                CreateWorker.worker.get(i).setMx(CreateWorker.worker.get(i).getCxTemp());
                CreateWorker.worker.get(i).setMy(CreateWorker.worker.get(i).getCyTemp());

                CreateWorker.worker.get(i).setCxTemp(CreateWorker.worker.get(i).getCx());
                CreateWorker.worker.get(i).setCyTemp(CreateWorker.worker.get(i).getCy());
            }

            if (CreateWorker.worker.get(i).getxInkrement() != CreateWorker.worker.get(i).getCx() || CreateWorker.worker.get(i).getyInkrement() != CreateWorker.worker.get(i).getCy()) {
                
                if (CreateWorker.worker.get(i).getDirString() == "UP") {
                    CreateWorker.worker.get(i).setyInkrement(round(CreateWorker.worker.get(i).getyInkrement() - 0.05, 3));
                }
                if (CreateWorker.worker.get(i).getDirString() == "RIGHT") {
                    CreateWorker.worker.get(i).setxInkrement(round(CreateWorker.worker.get(i).getxInkrement() + 0.05, 3));
                }
                if (CreateWorker.worker.get(i).getDirString() == "DOWN") {
                    CreateWorker.worker.get(i).setyInkrement(round(CreateWorker.worker.get(i).getyInkrement() + 0.05, 3));
                }
                if (CreateWorker.worker.get(i).getDirString() == "LEFT") {
                    CreateWorker.worker.get(i).setxInkrement(round(CreateWorker.worker.get(i).getxInkrement() - 0.05, 3));
                }

            } else {
                dir = findShortestPathToMouse(CreateLab.borderArray, CreateWorker.worker.get(i).getCx(), CreateWorker.worker.get(i).getCy(), CreateWorker.worker.get(i).getMx(), CreateWorker.worker.get(i).getMy());

                if (dir == Direction.UP) {
                    CreateWorker.worker.get(i).setCy(CreateWorker.worker.get(i).getCy() - 1);
                    CreateWorker.worker.get(i).setDirString("UP");
                }
                if (dir == Direction.RIGHT) {
                    CreateWorker.worker.get(i).setCx(CreateWorker.worker.get(i).getCx() + 1);
                    CreateWorker.worker.get(i).setDirString("RIGHT");
                }
                if (dir == Direction.DOWN) {
                    CreateWorker.worker.get(i).setCy(CreateWorker.worker.get(i).getCy() + 1);
                    CreateWorker.worker.get(i).setDirString("DOWN");
                }
                if (dir == Direction.LEFT) {
                    CreateWorker.worker.get(i).setCx(CreateWorker.worker.get(i).getCx() - 1);
                    CreateWorker.worker.get(i).setDirString("LEFT");
                }
            }

        }

    }

    private static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    private static Direction findShortestPathToMouse(boolean[][] lab, int cx, int cy, int mx, int my) {
        // Create a queue for all nodes we will process in breadth-first order.
        // Each node is a data structure containing the cat's position and the
        // initial direction it took to reach this point.
        Queue<Node> queue = new ArrayDeque<>();

        // Matrix for "discovered" fields
        // (I know we're wasting a few bytes here as the cat and mouse can never
        // reach the outer border, but it will make the code easier to read. Another
        // solution would be to not store the outer border at all - neither here nor
        // in the labyrinth. But then we'd need additional checks in the code
        // whether the outer border is reached.)
        boolean[][] discovered = new boolean[CreateRaster.xNumRaster][CreateRaster.yNumRaster];
        // "Discover" and enqueue the cat's start position
        discovered[cx][cy] = true;
        queue.add(new Node(cx, cy, null));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // Go breath-first into each direction
            for (Direction dir : Direction.values()) {
                int newX = node.x + dir.getDx();
                int newY = node.y + dir.getDy();
                Direction newDir = node.initialDir == null ? dir : node.initialDir;

                // Mouse found?
                if (newX == mx && newY == my) {
                    return newDir;
                }

                // Is there a path in the direction (= is it a free field in the labyrinth)?
                // And has that field not yet been discovered?
                if (!lab[newX][newY] && !discovered[newX][newY]) {
                    // "Discover" and enqueue that field
                    discovered[newX][newY] = true;
                    queue.add(new Node(newX, newY, newDir));
                }
            }
        }

        throw new IllegalStateException("No path found");
    }

    public enum Direction {
        UP(0, -1),
        RIGHT(1, 0),
        DOWN(0, 1),
        LEFT(-1, 0);

        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }
    }

    private static class Node {

        final int x;
        final int y;
        final Direction initialDir;

        public Node(int x, int y, Direction initialDir) {
            this.x = x;
            this.y = y;
            this.initialDir = initialDir;
        }
    }
}
