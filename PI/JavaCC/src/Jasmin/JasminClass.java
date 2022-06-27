package Jasmin;

public class JasminClass{

    private String className = new String();

    private StringBuilder superClass =  new StringBuilder();

    public void setSuperClass(String superClassPart) {
        superClass.append(superClassPart);
    }

    public void setClass(String className){
        this.className = className;
    }

    public String getSuperClass(){
        return this.superClass.toString();
    }

    public String getClassName(){
        return this.className;
    }


}