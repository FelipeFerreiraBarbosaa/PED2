
    public void print(Node root) {

        if (root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
                width = (int) Math.pow(2, height - 1);

        List<Node> current = new ArrayList<Node>(1),
                next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++)
            sb.append(' ');
        String textBuffer;

        for (int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

            textBuffer = sb.toString();

            for (Node n : current) {

                System.out.print(textBuffer);

                if (n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();

            if (i < height - 1) {

                for (Node n : current) {

                    System.out.print(textBuffer);

                    if (n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }
}
