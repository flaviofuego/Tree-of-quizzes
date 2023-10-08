package Lab1_2new;
import java.util.ArrayList;

public class Arbol {
    Nodo raiz;
    ArrayList<Nodo> listanodos;
    ArrayList<Acertijo> Acertijosresueltos;
    ArrayList<Acertijo> Acertijosauxiliares;

    ArrayList<infonodo> infonodosss;

    public Arbol() {
        this.raiz = null;
        this.listanodos= new ArrayList<Nodo>();
        this.Acertijosresueltos= new ArrayList<Acertijo>();
        this.Acertijosauxiliares= new ArrayList<Acertijo>();
        this.infonodosss= new ArrayList<infonodo>();

    }
    //Funcion realizada en clase
    public static int alturaArbol(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(alturaArbol(nodo.izquierdo), alturaArbol(nodo.derecho)) + 1;
    }
    public void agregar(int dato) {
        Nodo nodo = new Nodo(dato);
        if (this.raiz == null) {
            this.raiz = nodo;
            this.raiz.alturaNodo=0;
            this.listanodos.add(nodo);
        } else {
            agregarRecursivo(this.raiz, nodo);
            this.listanodos.add(nodo);
        }

    }
    //agregar modificado para que actualize la altura de los nodos a medida que se agrega un nuevo nodo
    public void agregarRecursivo(Nodo nodo, Nodo nuevoNodo) {
        if (nuevoNodo.dato < nodo.dato) {
            if (nodo.izquierdo == null) {
                nodo.izquierdo = nuevoNodo;
                nodo.izquierdo.alturaNodo=Alturanodo(nodo)+1;
            } else {
                agregarRecursivo(nodo.izquierdo, nuevoNodo);
                nodo.alturaNodo=Alturanodo(nodo);
            }
        } else {
            if (nodo.derecho == null) {
                nodo.derecho = nuevoNodo;
                nodo.derecho.alturaNodo=Alturanodo(nodo)+1;
            } else {
                agregarRecursivo(nodo.derecho, nuevoNodo);
                nodo.alturaNodo=Alturanodo(nodo);
            }
        }
    }
    //metodo hecho en clase
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
    //metodo hecho en clase
    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.dato;
        printTree(M, root.izquierdo, col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.derecho, col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
    //metodo hecho en clase
    public void TreePrinter(Nodo nodoactual,ArrayList<Nodo> visitados) {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        System.out.println("Arbol de Aventuras");
        System.out.println("Te encuentras Actualmente en: " + nodoactual.nombrelugar);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    if(visitados.contains(this.buscarnodo(this.raiz,M[i][j]))){
                        System.out.print(this.buscarnodo(this.raiz,M[i][j]).nombrelugar + " ");
                    }

                }
            }
            System.out.println();
        }

    }
    public int [][] Matrizdeposicion() {

        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);

        return M;

    }
    public void debugger() {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        System.out.println("Arbol de Aventuras");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
    public void agregarlugar(int dato,String nombrelugar,String descripcion) {
        Nodo nodo = new Nodo(dato);
        nodo.nombrelugar=nombrelugar;
        nodo.descripcion=descripcion;
        if (this.raiz == null) {
            this.raiz = nodo;
            this.raiz.alturaNodo=0;
            this.listanodos.add(nodo);
        } else {
            agregarRecursivo(this.raiz, nodo);
            this.listanodos.add(nodo);
        }

    }
    public void muestrallegada(Nodo nodoactual,ArrayList<Nodo> visitados, Nodo llegada) {
        int h = alturaArbol(this.raiz);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.raiz, col / 2, 0, h);
        System.out.println("Arbol de Aventuras");
        System.out.println("Te encuentras Actualmente en: " + nodoactual.nombrelugar);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    if(visitados.contains(this.buscarnodo(this.raiz,M[i][j]))){
                        System.out.print(this.buscarnodo(this.raiz,M[i][j]).nombrelugar + " ");
                    }
                    if(this.buscarnodo(this.raiz,M[i][j])==llegada){
                        System.out.print(this.buscarnodo(this.raiz,M[i][j]).nombrelugar + " ");
                    }

                }
            }
            System.out.println();
        }
    }

    public Nodo buscarnodo(Nodo nodo, int dato){
        if(nodo == null){
            return null;
        }
        if(nodo.dato == dato){
            return nodo;
        }else{
            if(dato < nodo.dato){
                return buscarnodo(nodo.izquierdo, dato);
            }else{
                return buscarnodo(nodo.derecho, dato);
            }
        }
    }
    public int Alturanodo(Nodo nodo){
        if (nodo==null) {
            return 0;
        }
        return nodo.alturaNodo;
    }
}