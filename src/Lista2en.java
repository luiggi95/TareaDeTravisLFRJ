/*lista doblemente enlazada
DESAFIO HACERLO para las circulares: simple y doble

Nombre: Reyes Jara Luiggi Fernando
curso: Tercer Nivel "A"
*/


import java.io.IOException;
import java.util.Scanner;



class CNodo
{
	int dato;
	CNodo siguiente;
	CNodo anterior;

	public CNodo()
	{
		anterior = null;
                siguiente = null;
	}
}

class CLista
{
	CNodo cabeza;
        CNodo actual;
	public CLista()
	{
		cabeza = null;
                actual = null;
	}
  
      public void Menu() throws IOException  {
          
       Scanner entrada = new Scanner(System.in);
        System.out.println("\n\n\t\t\tLista Doblemente Enlazada Circular");
        System.out.println("\n\n\t\t\t---------Menú Principal ---------");
        System.out.println("\t\t\t+ 1 Ingresar                       +");
        System.out.println("\t\t\t+ 2 Eliminar                       +");
        System.out.println("\t\t\t+ 3 Buscar                         +");
        System.out.println("\t\t\t+ 4 Recorrido                      +");
        System.out.println("\t\t\t+ 5 Salir                          +");
        System.out.println("\t\t\t------------------------------------");
        System.out.println("\t\t\tDigite una opción:");
        int opcion = entrada.nextInt(); 
        Opciones(opcion);
    }
      public void Opciones(int opcion) throws IOException   {
        switch (opcion) {

            case 1:   
               InsertarDato();
               Menu();
                break;
            case 2:
               EliminarDato();
               Menu();
               break;
            case 3:
               BuscarDato();
               Menu();
               break; 
            case 4: 
               RecorridoDato();
                Menu();
                break;
            case 5:
                System.exit(1);
                Menu();
            default:
                Menu();
                break;
        }
     }

        public void InsertarDato()throws IOException
	{
                System.out.println("Digite el dato para la Lista");
                Scanner entrada =new Scanner(System.in);    
                int dat=entrada.nextInt(); 
        	CNodo CNodo;
                CNodo ant=null,sig=null;
		CNodo = new CNodo();
		CNodo.dato=dat;
                int ban=0;
               
		if (cabeza== null)
                {   CNodo.siguiente=CNodo;
                    CNodo.anterior=CNodo;
                    cabeza = CNodo;
                    actual= CNodo;
                }
                else { 
                    if (dat<cabeza.dato)
                        {  
                            ant=cabeza.anterior;
                            CNodo.anterior=ant;
                            CNodo.siguiente=cabeza;
                            cabeza.anterior=CNodo;
                            ant.siguiente=CNodo;
                            cabeza = CNodo;
                            actual=CNodo;
                        }
                    else {  ant=actual;
                            sig=actual;
                            while (ban==0)
                            {   
                                if (dat>=sig.dato)
                                {
                                    ant=sig;
                                    sig=sig.siguiente;
                                    
                                    if(sig==cabeza) {ban=1;}
                                }
                                else { 
                                if (dat<sig.dato) {
                                            sig=ant;
                                            ant=ant.anterior;
                                            if(ant==cabeza){ban=1;}
                                        }
                                    }
                                if ((ant==null)||(sig==null)) {ban=1;}
                                else {
                                        if ((dat<sig.dato)&&(ant.dato<dat))
                                        {ban=1;}
                                    }
                            }
                            if (ant!=null) ant.siguiente=CNodo;
                            CNodo.anterior=ant;
                            CNodo.siguiente=sig;
                            actual=CNodo;
                            if (sig!=null) sig.anterior=CNodo;
                        }
                }
    }
        public void EliminarDato()throws IOException{
          System.out.println("Ingrese  el dato a Eliminar:");
          Scanner entrada =new Scanner(System.in);    
          int dat=entrada.nextInt(); 	          
            CNodo ant=null,sig=null;
           int ban=0;
           if (Vacia())  System.out.print("Lista vacía: ");{
           
           
               if (dat<cabeza.dato) 
                   
                   System.out.print("Dato no existe ");
               else 
                   if (cabeza.dato==dat){
                 
                   if(cabeza==cabeza.siguiente){
                       cabeza=null;
                       actual=null;
                       
                   }
                   else{
                       ant=cabeza.anterior;
                       cabeza=cabeza.siguiente;
                       cabeza.anterior=ant;
                       ant.siguiente=cabeza;
                       actual=ant;
                
                   }
               }else
               {
               ant=actual;
               sig=actual;
               while(ban==0)
               {
               
                   if((ant.dato<dat)&&(dat<sig.dato)){ban=1;}
               else{
                   if(dat>sig.dato)
                   {
                      ant=sig;
                      sig=sig.siguiente;
                      if(sig==cabeza){ban=1;}
                   }
                   else
                       if(dat<sig.dato)
                       {
                            sig=ant;
                            ant=ant.anterior;
                        if(ant==cabeza)
                            {ban=1;}
                       }
                if((sig.dato==dat)||(ant.dato==dat))
                    {ban=1;}
            }
        } 
        if(dat==sig.dato)
        {
            ant=sig.anterior;
            ant.siguiente=sig.siguiente;
            sig=sig.siguiente;
            sig.anterior=ant;
            actual=sig;
            
        }else 
            if(dat==ant.dato)
            {
                 ant=ant.anterior;
                 ant.siguiente=sig;
                 sig.anterior=ant;
                 actual=sig;
             }  
        else System.out.println("Dato no existe");
        }
    }
}

         public boolean Vacia()
        {    
            return(cabeza==null);
        }

	public void RecorridoDato(){
            CNodo Nodo;
            Nodo=cabeza;
            if (!Vacia()) 
            {
                System.out.println("Los datos en lista son: ");
                do{
                    System.out.print(" " + Nodo.dato +" ");
                    Nodo = Nodo.siguiente;
                  }while (Nodo!=cabeza);
            }
            else System.out.print("Lista vacía");
            }

        
        public void BuscarDato () throws IOException { 
                
                System.out.println("Ingrese el dato a Buscar :");
                Scanner entrada =new Scanner(System.in);    
                int dat=entrada.nextInt();          
                int bandera=0;
                int cont=0;
		 CNodo Nodo;
                Nodo=cabeza;
                if (!Vacia()) 
                {
                do
                   {	
                       if(Nodo.dato==dat)
                       {
                           bandera=1;
                       }
                       
                       Nodo = Nodo.siguiente;
                       
                }while (Nodo!=cabeza);
                
                    if(bandera==1)
                {
                       System.out.print("El " + dat +" encontrado");
                }
                       else{
                           System.out.println("El " +dat+" no existe");
                       }
                }
                
                else System.out.print("Lista Vacía");
	}
}
public class Lista2en {

    public static void main(String[] args) throws IOException {
                CLista Lista = new CLista();
                Lista.Menu();
    }
    
}
