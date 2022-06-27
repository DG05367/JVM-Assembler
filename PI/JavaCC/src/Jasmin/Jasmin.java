package Jasmin;

import java.util.*;

public class Jasmin {
    
    private JasminClass jclass = new JasminClass();

    private List<Method> methods = new ArrayList<Method>();

    public String getCode(){ 

        var code = new StringBuilder();

        //Class
        code.append(".class ");
        code.append("public ");
        code.append(jclass.getClassName()).append("\n");
        //Super
        code.append(".super ");
        code.append(jclass.getSuperClass()).append("\n\n");

        //Methods
        for (var method: methods) {
            code.append(method.getCodeMethod());
        }




        
        return code.toString();
    }

    public void setClassName(String className){
        jclass.setClass(className);
    }

    public void setSuperClassName(String superClassNamePart){
        jclass.setSuperClass(superClassNamePart);
    }

    public void setMethodAccessModifier(String methodAccessModifier){
        Method method = new Method();

        method.setMethodAccessModifier(methodAccessModifier);

        methods.add(method);
    }

    public void setMethodStatic(){
        methods.get(methods.size() - 1).setStatic(true);
    }

    public void setMethodName(String methodName){
        methods.get(methods.size() - 1).setMethodName(methodName);
    }

    public void setParameter(String parameter){
        methods.get(methods.size() - 1).addParameter(parameter);
    }

    public void setLocals(String locals){
        methods.get(methods.size() - 1).setLocals(locals);
    }

    public void setStack(String stack){
        methods.get(methods.size() - 1).setStack(stack);
    }

    public void addInstruction(String instruction,String doubleDot,String label){
        methods.get(methods.size() - 1).addInstruction(instruction,doubleDot,label);
    }
    public void addOperandInst(String Op){
        methods.get(methods.size() - 1).addOperandInst(Op);
    }

    public void addOperandInstPath(String Op){
        methods.get(methods.size() - 1).addOperandInstPath(Op);
    }
    

}