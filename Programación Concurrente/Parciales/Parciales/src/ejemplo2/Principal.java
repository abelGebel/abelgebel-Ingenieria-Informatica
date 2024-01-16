package ejemplo2;
/*
Una planta de ensamblado de dispositivos posee 3 mesas donde cada una permite el
ensamblado de un único dispositivo al mismo tiempo pero simultáneamente. El armado de un
dispositivo transita por 3 fases, la Fase 1 requiere el empleo de un destornillador y una pinza,
la Fase 2 requiere el empleo de dos sargentos y la Fase 3 requiere el empleo de dos pinzas.
Cada Fase si bien independientes, se realizan en la misma mesa y en el orden mencionado
(Fase 1, 2 y 3), y como habrá observado, con herramientas distintas. Se desea armar un lote de
100 componentes y la empresa solo cuenta con 4 pinzas, 2 destornilladores y 4 sargentos. El
tiempo que insume cada fase está dado por: Fase 1 es T, el de la Fase 2 es ½ de T y el de la
Fase 3 es 2T. Simula la situación empleando semáforos y muestre por pantalla cada etapa del
proceso indicando el estado de avance de cada componente a medida que transita por las
distintas etapas. Tome T = 400ms.
*/
public class Principal {

	public static void main(String[] args) {
		Semaforo semaforo = new Semaforo();
		for(int i=1;i<=10;i++) {
			Dispositivo dispositivo = new Dispositivo(semaforo,i);
			dispositivo.start();
		}

	}

}
