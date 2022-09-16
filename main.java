public static void main(String args[]) {
    AVLTree t = new AVLTree();
    Node root = null;
    while (true) {
        System.out.println("(1) Insert");
        System.out.println("(2) Delete");

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();

            if (Integer.parseInt(s) == 1) {
                System.out.print("Value to be inserted: ");
                root = t.insert(root, Integer.parseInt(bufferRead.readLine()));
            } else if (Integer.parseInt(s) == 2) {
                System.out.print("Value to be deleted: ");
                root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
            } else {
                System.out.println("Invalid choice, try again!");
                continue;
            }

            t.print(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
