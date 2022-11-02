class NumNode {
    private double value;

    NumNode(double value) {
        this.value = value;
    }

    double getValue() {
        return value;
    }

    void setValue(double value) {
        this.value = value;
    }
}

class OpNode {
    private char op;
    private NumNode leftNumber;
    private NumNode rightNumber;
    private OpNode leftOperator;
    private OpNode rightOperator;

    OpNode(char op) {
        this.op = op;
    }

    char getOp() {
        return op;
    }

    void setOp(char op) {
        this.op = op;
    }

    NumNode addLeft(NumNode leftNumber) {
        this.leftNumber = leftNumber;
        return leftNumber;
    }

    NumNode addRight(NumNode rightNumber) {
        this.rightNumber = rightNumber;
        return rightNumber;
    }

    OpNode addLeft(OpNode leftOperator) {
        this.leftOperator = leftOperator;
        return leftOperator;
    }

    OpNode addRight(OpNode rightOperator) {
        this.rightOperator = rightOperator;
        return rightOperator;
    }

    double evaluate() {
        double leftValue = 0;
        double rightValue = 0;
        if (leftNumber != null) {
            leftValue = leftNumber.getValue();
        } else {
            leftValue = leftOperator.evaluate();
        }
        if (rightNumber != null) {
            rightValue = rightNumber.getValue();
        } else {
            rightValue = rightOperator.evaluate();
        }
        switch (op) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                return 0;
        }
    }
}

class Arithmetic {
    public static void main(String[] args) {

        OpNode n = new OpNode('+');
        NumNode two = new NumNode(2);
        NumNode three = new NumNode(3);
        n.addLeft(two);
        n.addRight(three);

        double x = n.evaluate();
        System.out.println("x = " + x);

        OpNode n2 = new OpNode('+');
        n2.addLeft(new NumNode(3));
        n2.addRight(new NumNode(4));

        OpNode n3 = new OpNode('*');
        n3.addLeft(new NumNode(2));
        n3.addRight(n2);

        double y = n3.evaluate();
        System.out.println("y = " + y);
    }
}