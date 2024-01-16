package ejemplo5Contador;

/*
La clase Contador define la región crítica. Tiene un atributo de tipo entero inicializado
a 1 ysu correspondiente getter y setter.
*/

public class Contador {
private int contador=0;

public void setContador(int nContador){
    contador=nContador;
}

public int getContador(){
    return contador;
}
}