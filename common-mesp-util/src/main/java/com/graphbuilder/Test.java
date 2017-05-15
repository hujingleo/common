package com.graphbuilder;

import com.graphbuilder.math.Expression;
import com.graphbuilder.math.ExpressionTree;
import com.graphbuilder.math.FuncMap;
import com.graphbuilder.math.VarMap;

//java基于mesp计算和实现数学公式、数学表达式
//http://sourceforge.net/projects/expression-tree/files/
public class Test{

    public static void main(String[] args) {

        //test001();
        test002();
    }

    private static void test002() {

        //y=ax2+bx+c
        Expression expression=ExpressionTree.parse("a+b+c*x");
        VarMap vm = new VarMap(false);
        vm.setValue("a", 1);
        vm.setValue("b", 2);
        vm.setValue("c", 1);
        vm.setValue("x", 100);
        //y=x^2+2x+1=(x+1)^2
        double result=expression.eval(vm, null);
        log.info(result);
        vm.setValue("a", 1);
        vm.setValue("b", 4);
        vm.setValue("c", 4);
        vm.setValue("x", 1);
        //y=x^2+4x+4=(x+2)^2
        result=expression.eval(vm, null);
        log.info(result);

    }

    private static void test001() {

        String s = "pi*r^2";
        Expression x = ExpressionTree.parse(s);

        VarMap vm = new VarMap(false /* case sensitive */);
        vm.setValue("pi", Math.PI);
        vm.setValue("r", 5);

        FuncMap fm = null; // no functions in expression

        log.info(x); // (pi*(r^2))
        log.info(x.eval(vm, fm)); // 78.53981633974483

        vm.setValue("r", 10);
        log.info(x.eval(vm, fm)); // 314.1592653589793
    }
}
