/* El juego debe ser una aventura interactiva donde los jugadores exploran diferentes
         mundos a través de la navegación del árbol. Cada nodo del árbol representa un lugar
         o escenario en el juego, y los jugadores deben tomar decisiones que los llevarán a
         través de distintos caminos y desafíos. A medida que avanzan en la aventura.
         Los jugadores pueden encontrar obstáculos, resolver acertijos o tomar decisiones
         morales que afectarán el desarrollo de la historia. Su programa debe ser capaz de
         manejar eficientemente la estructura del árbol y proporcionar una experiencia de juego
         envolvente y divertida para los usuarios.
         ¡Es hora de poner a prueba sus habilidades en estructuras de datos y programación
         creando un emocionante juego de aventuras!
         Mecánica del Juego - "Aventura en el Bosque Misterioso"
         Inicio del Juego:
         El jugador comienza desde la raíz del árbol y recibe un mensaje de "¡Bienvenido a la
         Aventura en el Bosque Misterioso!"
         Se proporcionan las instrucciones del juego, que consisten en navegar a través del
         bosque tomando decisiones para avanzar.
         Navegación:
         Para avanzar en el juego, el jugador debe escribir "izquierda" o "derecha" según su
         elección actual. Si se cambia de nivel, el juego debe informar el nombre del nuevo
         mundo al que se ha ingresado. El jugador también puede escribir "salir" en cualquier
         momento para abandonar el juego.
         Acertijos:
         Cada vez que el jugador avanza hacia un nuevo nodo en el árbol, se le presenta un
         acertijo o enigma relacionado con el entorno del juego.
         Si el jugador resuelve el acertijo correctamente, se le da la opción de elegir si va
         "izquierda" o "derecha". Sino lo resuelve, el programa deberá generar un nuevo
         acertijo hasta que éste sea resuelto por el usuario.
         Arribo a la Hoja de Llegada:
         La hoja de llegada debe ser generada automáticamente por el juego una vez se inicie
         la partida, debe estar ubicada en el nivel más alto del árbol.
         El objetivo del juego es arribar a la "Hoja de Llegada" del árbol, que representa el
         destino final del jugador en el bosque misterioso.
        Al arribar a la "Hoja de Llegada," el juego se considera exitoso y se muestra un
        mensaje de victoria.
        No arribar a la hoja de llegada:
        Si el jugador arriba a una hoja que no es la "Hoja de Llegada," se le proporcionará una
        pista sobre dónde se encuentra la "Hoja de Llegada." El juego imprimirá el árbol hasta
        ese punto y mostrará la "Hoja de Llegada" en el árbol.
        Fin del Juego:
        El juego continúa hasta que el jugador arriba a la "Hoja de Llegada" o decide "salir"
        del juego.
        Cuando el jugador arriba a la "Hoja de Llegada," se muestra un mensaje de victoria y
        el juego termina*/
/*
*- Crea una estructura de datos que represente los nodos del árbol(Arbol binario). Cada nodo debe contener información sobre el lugar o escenario en el juego, así como los acertijos y las opciones disponibles para avanzar.
*-Construye el árbol que representará la aventura en el bosque misterioso. Esto implica crear todos los nodos y establecer las relaciones entre ellos.
*-Inicia el juego desde la raíz del árbol y muestra el mensaje de bienvenida y las instrucciones.
 -Implementa la navegación del jugador. Los comandos "izquierda" y "derecha" deben mover al jugador a través del árbol y mostrar información sobre el lugar actual.
 -Implementa la opción "salir" para que el jugador pueda abandonar el juego en cualquier momento.
 -Agrega la lógica para presentar acertijos o enigmas en cada lugar del juego. Los acertijos deben relacionarse con el entorno del juego.
 -Permite que el jugador resuelva los acertijos. Si lo resuelve correctamente, dale la opción de continuar "izquierda" o "derecha". Si no, genera un nuevo acertijo hasta que se resuelva.
 -Implementa la condición de victoria cuando el jugador llegue a la "Hoja de Llegada" y muestra un mensaje de victoria.
*- Si el jugador llega a una hoja que no es la "Hoja de Llegada", muestra una pista sobre dónde se encuentra la "Hoja de Llegada" y muestra el árbol hasta ese punto.
* El juego debe continuar hasta que el jugador llegue a la "Hoja de Llegada" o decida salir.
* Cuando el jugador llegue a la "Hoja de Llegada", muestra un mensaje de victoria y termina el juego.
* Documenta tu código de manera adecuada para que sea comprensible para otros desarrolladores y para futuras actualizaciones.
*
* */
package Lab1_2new;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Arregocesf
 */



public class Lab1_2new {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Arbol arbol = new Arbol();
        int[] vectorn = new int[13]; //Extension del laberinto
        SClip welove;
        welove = new SClip("sound/videoplayback.wav");
        //un array de numeros aleatorios que no se repiten
        //esto se valida con 1 vector de nodos y un vector auxiliar que ayuda a validar que no se repitan
        for (int i = 0; i < vectorn.length; i++) {
            int n = (int) (Math.random() * 100);
            vectorn[i] = n;
            for (int j = 0; j < i; j++) {
                if (vectorn[i] == vectorn[j]) {
                    i--;
                }
            }
        }


        //se creal el arbol con los numeros aleatorios
        for (int j : vectorn) {
            arbol.agregar(j);
            //System.out.println(arbol.Alturanodo(arbol.buscarnodo(arbol.raiz, j))); //pa comprobar que la altura de cada nodo ta bien
        }


        //matriz de posicion de los nodos
        int[][] matriz = arbol.Matrizdeposicion();


        //Array de todos los nodos en el ultimo nivel
        ArrayList<Nodo> nodosultimonivel = new ArrayList<Nodo>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(i==matriz.length-1) {
                    if(matriz[i][j]!=0) {
                        nodosultimonivel.add(arbol.buscarnodo(arbol.raiz, matriz[i][j]));
                        //System.out.print("//"+ arbol.buscarnodo(arbol.raiz, matriz[i][j]).dato);
                    }
                }
            }
        }
        System.out.println();


        //se le asigna el nodo de llegada al arbol
        int p = nodosultimonivel.get((int) (Math.random() * nodosultimonivel.size())).dato;
        //System.out.println("el nodo de llegada es: " + arbol.buscarnodo(arbol.raiz, p).dato);


        //se le asigna el nodo de inicio al arbol
        arbol.raiz.nombrelugar = "Entrada del Bosque";
        arbol.raiz.descripcion = "¡Bienvenido a la Aventura en el Bosque Misterioso!";


        //arraylist de nodos visitados
        ArrayList<Nodo> visitados = new ArrayList<Nodo>();
        Nodo nodo_actual = arbol.raiz;


        //se rellena la lista de acertijos

        arbol.Acertijosresueltos.add(new Acertijo("Puedes romperme sin tocarme y hablar de mi sin decir una palabra. ¿Que soy?", "silencio"));
        arbol.Acertijosresueltos.add(new Acertijo("¿Que cosa es la que cuanto mas se quita, mas grande es?", "agujero"));
        arbol.Acertijosresueltos.add(new Acertijo("Tengo agujas, pero no coso; tengo numeros, pero no cuento. ¿Que soy?", "reloj"));
        arbol.Acertijosresueltos.add(new Acertijo("¿Que cosa es la que cuanto más se moja, mas se seca?", "toalla"));
        arbol.Acertijosresueltos.add(new Acertijo("¿Que tiene un ojo, pero no puede ver?", "aguja"));
        arbol.Acertijosresueltos.add(new Acertijo("¿Que cosa es la que cuanto más grande, menos se ve?", "oscuridad"));
        arbol.Acertijosresueltos.add(new Acertijo("¿Qué cosa es la que todos te dicen, pero nunca puedes decir tu?", "secreto"));
        arbol.Acertijosresueltos.add(new Acertijo("Puedes llevarme en la mano, pero no puedes sostenerme por mucho tiempo. ¿Que soy?", "agua"));
        arbol.Acertijosresueltos.add(new Acertijo("Aunque hablo sin boca y oigo sin oidos, siempre cuento historias.¿Que soy? ", "libro"));
        arbol.Acertijosresueltos.add(new Acertijo("Todos tienen uno, pero nadie lo puede compartir. ¿Qué es?", "nombre"));
        arbol.Acertijosresueltos.add(new Acertijo("Siempre está en el pasado, pero nunca en el presente. ¿Que es?", "historia"));
        arbol.Acertijosresueltos.add(new Acertijo("Por naturaleza soy invisible, pero me puedes ver a diario adonde quiera que vas", "aire"));

        //Lista de acertijos auxiliares
        arbol.Acertijosauxiliares.add(new Acertijo("No poseo inicio ni final y me encuentro al final de cada taza", "circulo"));
        arbol.Acertijosauxiliares.add(new Acertijo("¿Dónde hay rios sin agua, ciudades sin casas y bosques sin arboles?", "mapa"));
        arbol.Acertijosauxiliares.add(new Acertijo("Todos pasan preguntando por mi, pero yo ni paso ni pregunto por nadie", "calle"));
        arbol.Acertijosauxiliares.add(new Acertijo("Se la das a todo el mundo y aun asi te quedas con ella, ¿qué es?", "mano"));
        arbol.Acertijosauxiliares.add(new Acertijo("No puede morder ni puede ladrar, pero tiene dientes y tu casa busca resguardar. ¿Qué es?", "llave"));
        arbol.Acertijosauxiliares.add(new Acertijo("¿Cual cosa hay que romper antes de usar?", "huevo"));
        arbol.Acertijosauxiliares.add(new Acertijo("Es puma y no es animal; vuela y flota. ¿Que sera?", "espuma."));
        arbol.Acertijosauxiliares.add(new Acertijo("No soy un ave, pero vuelo sin alas. No soy un rio, pero fluyo sin parar, ¿Que soy? ", "tiempo"));
        arbol.Acertijosauxiliares.add(new Acertijo("Es tan ligero como una pluma, pero ni el hombre más fuerte puede sostenerlo durante mucho tiempo, ¿Que puede ser? ", "aire"));
        arbol.Acertijosauxiliares.add(new Acertijo("Marco las horas pero no soy un reloj, cuando me hago notar todos se voltean a verme. ¿Qué soy?", "campana"));
        arbol.Acertijosauxiliares.add(new Acertijo("¿Qué cosa es la que todos te dicen, pero nunca puedes decir tu?", "secreto"));
        arbol.Acertijosauxiliares.add(new Acertijo("Puedes llevarme en la mano, pero no puedes sostenerme por mucho tiempo. ¿Que soy?", "agua"));
        arbol.Acertijosauxiliares.add(new Acertijo("Aunque hablo sin boca y oigo sin oidos, siempre cuento historias.¿Que soy? ", "libro"));
        arbol.Acertijosauxiliares.add(new Acertijo("Todos tienen uno, pero nadie lo puede compartir. ¿Qué es?", "nombre"));
        arbol.Acertijosauxiliares.add(new Acertijo("Siempre está en el pasado, pero nunca en el presente. ¿Que es?", "historia"));
        arbol.Acertijosauxiliares.add(new Acertijo("Por naturaleza soy invisible, pero me puedes ver a diario adonde quiera que vas", "aire"));


        //se le asigna un acertijo random a cada nodo del arbol
        for (int i = 0; i < vectorn.length-1; i++) {
            //validar que el acertijo a asignar no se repita
            arbol.buscarnodo(arbol.raiz, vectorn[i]).acertijo = arbol.Acertijosresueltos.get((int) (Math.random() * arbol.Acertijosresueltos.size()));
            arbol.Acertijosresueltos.remove(arbol.buscarnodo(arbol.raiz, vectorn[i]).acertijo);
            //if(arbol.buscarnodo(arbol.raiz, vectorn[i]).dato==arbol.buscarnodo(arbol.raiz, p).dato) System.out.println("Si esta el nodo salida");
        }

        //se rellena la lista de informacion de los nodos
        arbol.infonodosss.add(new infonodo("Torre de las Sombras","Una torre alta y misteriosa que se alza en el centro del laberinto, rodeada de densas nieblas y rumores de criaturas oscuras que acechan en su interior."));
        arbol.infonodosss.add(new infonodo("Bosque de Susurros","Un frondoso bosque que oculta secretos ancestrales. Los árboles parecen susurrar entre ellos, y sus caminos son engañosos, llevando a los aventureros a callejones sin salida."));
        arbol.infonodosss.add(new infonodo("Lago de los Espejos","Un lago de aguas cristalinas que reflejan la luz de la luna. En su centro se alza una isla con una estatua de una mujer con los ojos vendados."));
        arbol.infonodosss.add(new infonodo("Fortaleza de los Olvidados","Una antigua fortaleza en ruinas donde los desterrados y los exiliados encontraron refugio. Sus pasillos están llenos de trampas y pasajes secretos."));
        arbol.infonodosss.add(new infonodo("Cueva de los Lamentos","Una cueva oscura y húmeda donde los gritos de los condenados resuenan en las paredes. En su interior se encuentra una puerta de piedra con extraños símbolos tallados."));
        arbol.infonodosss.add(new infonodo("Cementerio de los Caídos","Un cementerio abandonado donde los muertos no descansan en paz. Las tumbas están cubiertas de musgo y las lápidas están rotas."));
        arbol.infonodosss.add(new infonodo("Casa de los Recuerdos","Una casa de madera donde los recuerdos de los vivos y los muertos se entrelazan. En su interior se encuentra una mesa con un tablero de ajedrez."));
        arbol.infonodosss.add(new infonodo("Ciudad de las Quimeras","Una ciudad abandonada donde las estatuas cobran vida durante la noche. Los laberintos de calles estrechas están habitados por criaturas mitológicas que desafían a los intrusos."));
        arbol.infonodosss.add(new infonodo("Catedral de los Condenados","Una catedral gótica donde los condenados se reúnen para orar. Las vidrieras están rotas y las estatuas de los santos están cubiertas de polvo."));
        arbol.infonodosss.add(new infonodo("Cavernas del Abismo","Un sistema de cuevas subterráneas profundas y retorcidas. Las paredes están cubiertas de extrañas inscripciones, y el eco de los lamentos de almas perdidas llena el aire." ));
        arbol.infonodosss.add(new infonodo("Puente de los Espiritus","Un puente colgante sobre un abismo oscuro y tenebroso. Se dice que las almas de los condenados susurran a los que se aventuran a cruzar, intentando llevarlos a la perdición."));
        arbol.infonodosss.add(new infonodo("Castillo de los Espejismos","Un castillo en el que las habitaciones cambian constantemente de forma y tamaño. Los espejismos y las ilusiones confunden a los intrépidos exploradores."));
        arbol.infonodosss.add(new infonodo("Tumba del Caballero Errante","Una tumba antigua y siniestra que alberga los restos de un caballero maldito. La entrada está protegida por trampas mortales y guardianes espectrales."));
        arbol.infonodosss.add(new infonodo("Templo de las Pruebas Eternas","Un templo en ruinas donde los aventureros deben superar desafíos mortales para avanzar. Cada sala presenta una nueva y peligrosa prueba."));

        //nombre y descripcion de los nodos
        for (int i = 1; i < vectorn.length-1; i++) {
            int n = (int) (Math.random() * arbol.infonodosss.size());
            arbol.buscarnodo(arbol.raiz, vectorn[i]).nombrelugar = arbol.infonodosss.get(n).nombrelugar;
            arbol.buscarnodo(arbol.raiz, vectorn[i]).descripcion = arbol.infonodosss.get(n).descripcion;
            arbol.infonodosss.remove(n);
        }
        arbol.buscarnodo(arbol.raiz, p).nombrelugar = "Salida del bosque";
        arbol.buscarnodo(arbol.raiz, p).descripcion = "¡En hora buena aventurero! parece que tu viaje ha llegado a su fin, tu arduo esfuerzo ha dado frutos y seras recompensado." +
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠈⠀⠄⠂⠄⢂⠈⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠠⠁⠌⠄⡑⠄⡂⢂⠡⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠂⠀⡁⠌⠄⠅⢅⢊⠰⡐⠠⠂⠅⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠄⠂⠄⡂⠅⠅⡂⠪⡐⡌⠪⠨⢂⠂⠅⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠂⠐⠈⠄⢂⠅⡐⠨⠨⡂⡊⢜⠨⠠⠡⢁⠂⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠠⠁⠐⠠⢁⢂⠊⠌⢌⠐⠄⠅⡊⠨⠨⠐⡈⠄⠡⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠈⠀⠠⠐⠀⠐⠀⠂⠠⠈⠄⢁⠂⡁⢂⠠⠐⠀⢁⠠⠈⡈⠄⠂⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠁⠀⠐⠀⠄⠀⠄⠈⢀⠂⠀⠂⠐⢀⠠⠀⢂⠠⠀⡂⠠⠀⠂⡀⠐⡀⠄⠂⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠠⠈⠀⢀⢀⠁⡠⢀⢂⠠⢐⢠⢠⢨⢨⡐⡄⡢⢨⢠⠠⡡⡠⠡⡁⡢⠀⠅⠠⠐⢀⠄⢁⠂⢀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⢀⠠⢐⠨⡠⢌⢆⢖⡲⡸⣘⢦⣓⢭⡣⣇⡧⣳⢵⢕⣧⣫⢮⢮⣪⣎⡎⣎⢖⢜⢬⣘⡐⡅⢄⢂⢐⠠⢀⠀⡀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⢀⢔⢰⢱⡱⣕⢧⣗⣗⣷⢽⣽⣞⣷⢽⣗⣟⣷⢿⣳⡿⣽⡷⣟⣿⣟⣿⣾⣻⣾⣯⣟⣷⣳⡽⣮⣞⡴⣢⡑⢔⠠⢀⠀⠀⠀⠀⠀⠀"+
                "\n⠐⢌⡪⣪⢧⣻⣺⢽⣞⣯⡿⣯⣷⢿⣾⣟⣷⡿⣾⣿⣟⣿⣟⣿⣿⢿⣻⣽⣾⣿⣷⡿⣟⣯⣿⢿⣿⣾⢿⣷⣻⣼⡰⣂⢂⠄⠀⠀⠀⠀"+
                "\n⠈⠔⡚⡮⣗⣟⣾⣻⣽⣷⡿⣿⢾⣿⢿⣽⣟⣿⣿⣯⣿⣿⣻⣟⣿⣿⣟⣿⣻⣽⣾⡿⣟⣿⣻⡯⣷⣿⢿⣯⣿⣞⢷⠵⠥⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠈⠊⠓⠛⠮⠯⣿⢾⣟⣿⣻⢽⣟⣗⣿⣽⣷⡿⣗⣿⣿⣿⣷⣿⣽⣟⡿⣯⣿⣻⣿⣽⣷⣿⢿⣾⣻⣽⢾⣻⡫⡫⠁⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠈⣾⣿⢷⣳⢝⠕⡕⡵⣯⣿⣽⣟⣿⣿⣷⣿⣿⣿⣷⣻⣻⣽⣾⣻⣞⣿⣺⣽⣿⢽⡯⡿⡽⡒⠁⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⡝⠎⠂⠀⠄⡝⣞⢮⢗⠯⣝⢍⡟⣟⢟⣝⢮⢯⣟⣞⣗⣟⣞⡾⣽⡞⡯⡏⢎⠃⡑⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⡀⢄⢐⠌⡎⡫⡊⢈⠘⡸⡱⣝⢗⡯⡯⣫⢗⡗⣗⢗⢗⡳⣝⢵⠝⠜⠠⠑⠁⠀⠀⠀⢄⠀⡠⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢂⢳⢽⢮⡿⡾⡚⡐⡰⡨⡢⡱⣱⡫⣏⢯⡺⡵⡹⢜⢎⠪⠂⠁⠁⠈⠈⠀⠀⠀⠀⠀⢸⣸⠠⡀⠄⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠨⠢⡍⣗⢯⣓⢜⡜⡼⡸⡪⡺⡪⡪⡪⡪⡪⡪⢊⠊⠄⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢕⢮⢊⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠘⠈⢇⢎⡗⣝⡜⡝⡪⡣⣋⢎⢮⣪⢪⡢⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢔⠔⠁⣸⢝⢆⠀⠄⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠈⠀⠀⠱⡸⣝⣗⣗⢵⢱⡐⡴⣦⢀⡀⠀⠀⡀⠀⣀⠜⠁⠀⠀⣪⣯⠢⡠⠀⠂⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⢌⢺⡺⡺⡪⡎⣖⣟⢎⠔⢭⢺⢮⣻⣢⣷⠁⠀⠀⠀⠀⣺⢎⢮⢢⢅⢂⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⠠⢑⠕⠕⡕⣝⢞⡕⡕⢕⢍⢢⠡⢑⢾⣻⣺⡥⠀⠀⠀⠀⡢⣯⢾⣹⣪⢖⢌⠌"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠌⠀⢂⠂⡌⢎⠪⡨⡊⡎⢎⢎⣗⡵⡱⡡⠊⠝⡷⡇⠀⠀⢀⢮⣞⣮⢯⣞⡷⣝⡆⠇"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⠌⠀⠌⢔⠪⡈⢆⢕⢜⢜⣜⡵⣿⡾⣿⠙⠪⡣⡕⡨⢑⠀⠀⠨⡯⣿⢾⣻⣮⢟⡎⠎⠂"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢎⠆⠃⠁⠈⡎⠪⡘⡌⡎⡖⡵⣳⣳⣟⣿⣻⡽⡁⠀⠀⠈⢚⡎⡔⡀⠈⠊⠕⠟⡝⢎⠃⠁⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⡢⠪⠂⠂⠀⢀⠱⡁⠅⠢⡨⡪⡸⡪⣳⢳⣳⣻⣪⡳⡐⠀⠀⠀⠀⠈⢪⡂⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠂⠄⠌⡀⠀⠀⠀⡨⢂⠢⡑⡱⡘⡜⡜⣎⢮⢳⡣⣗⢞⡮⡧⠡⠀⠀⠀⠀⠀⠱⣜⢄⠄⡀⡀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠄⡠⡡⣊⠔⠡⢂⠆⠀⠀⠀⢊⢐⠅⠕⡌⢎⢪⢪⡪⡎⡧⡳⢕⢏⠎⢎⠨⠂⠀⠀⠀⠀⠨⣳⢗⡵⡡⠢⢥⢀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⢄⠡⣪⠋⠀⠀⠠⡰⡑⠀⠀⠀⠐⠄⠕⡑⡌⡪⡪⡪⠪⡊⠎⢊⠌⡐⡌⡂⡃⠁⠢⡠⡀⠀⠈⠘⡽⣪⢷⢭⡣⡣⡫⠀⠀"+
                "\n⠀⠀⠀⠀⠈⢆⢞⡎⠀⠀⠀⠈⠊⠀⠀⠀⠀⠀⠁⠅⠊⢌⠊⠌⠌⠨⡠⠨⢀⠊⡀⢂⠠⢀⠡⠀⠑⠀⠀⠀⠀⠈⠘⠹⡳⢧⠣⡊⠔⠀"+
                "\n⠀⠀⠀⠀⠀⠠⡳⠍⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⠠⠐⡀⢂⠅⡄⠊⢀⠐⡀⠂⠄⡂⠄⡂⠅⠀⠀⠀⠀⠀⠀⠀⠀⠈⠃⠣⣂⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡐⠨⠨⠠⡃⠀⠌⢀⢂⠢⡡⡑⢄⠕⡐⠠⢀⠐⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⢌⠂⢀⠌⡐⡡⢂⠊⢔⢌⠆⡕⢌⢪⢐⢌⢆⢐⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢐⢐⠌⡂⢇⠣⡱⢘⠈⠌⠢⡣⡃⡪⡐⢌⢀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⢅⠂⠂⡁⠊⠔⠑⠈⠀⠀⠈⠈⡢⡊⡢⢑⢐⢐⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠨⢐⠈⠄⢂⠡⠀⠀⠀⠀⠀⠀⡐⡐⡐⠌⡒⡔⣐⢐⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⡀⢀⠀⡀⢀⠀⡈⠄⠌⠌⠄⠂⠀⠀⠀⠀⢀⢂⢆⢢⢡⢑⢌⢜⢔⡕⡄⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⢀⢁⢐⠠⢂⢐⢐⠐⡀⡂⡢⢁⠅⠅⠅⠀⠀⠀⠀⠀⠂⢆⢪⢸⢸⢸⡸⡱⡕⡕⠂⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠰⢌⣎⢦⡲⡑⡔⡔⡐⢌⠔⡐⢌⠔⡠⢅⠁⠀⠀⠀⠀⠀⠀⠁⠁⠑⠑⠁⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠨⠪⠳⡯⣾⣺⢼⣬⢎⢪⢊⡢⠱⡰⡐⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"+
                "\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠉⠉⠚⠛⠿⢶⢵⠱⣑⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";


        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
        int k= 0;//variable para que solo imprima las instrucciones una vez

        while (true) {
            visitados.add(nodo_actual); //lleva el registro de los nodos visitados
            if (nodo_actual == arbol.raiz && k == 0) {
                System.out.println(nodo_actual.descripcion);
                System.out.println("Para avanzar en el juego debes escribir 'Izquierda' o 'Derecha' según te parezca."
                        + "\nSi deseas salir del juego, escribe 'salir'."+ "\nSi deseas ver el mapa de tu recorrido actual, escribe 'arbol'."
                        + "\nSi llegas a un callejon sin salida se te dara una pista sobre donde se encuentra la hoja de llegada y podras elegir si intentar de nuevo o salir del juego."
                        + "\n");
                    k++;
                    continue;
            }

            if(nodo_actual == arbol.buscarnodo(arbol.raiz, p)){
                System.out.println(arbol.buscarnodo(arbol.raiz, p).descripcion);
                welove.play();
                break;
            }


            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Te encuentras en: "+ nodo_actual.nombrelugar);
            if (nodo_actual != arbol.raiz) System.out.println(nodo_actual.descripcion);
            System.out.print("En que direccion avanzaras ¿izquierda o derecha? tu decision has de tomar. (Escribe 'salir' para abandonar el juego): ");
            String decision = leer.nextLine();
            //se le quitan los espacios a la frase ingresada
            decision = decision.replaceAll("\\s", "");
            //valida que solo ingrese texto


            while(!decision.matches("[a-zA-Z]+")){
                System.out.print("En mi basto conocimiento no existe una lengua con tales palabras, Si conmigo te has de comunicar en mi lengua debes hablar:");
                decision = leer.nextLine();
                decision = decision.replaceAll("\\s", "");
            }
            if (decision.toLowerCase().contains("salir")) {
                System.out.println("Tu aventura en este misterioso bosque ha terminado, si deseas retomarla en otro momento te espero con los brazos abiertos.");
                break;
            }
            if (decision.toLowerCase().contains("arbol")) {
                arbol.TreePrinter(nodo_actual,visitados);
                continue;
            }

            Nodo siguiente_nodo;
            //condicional que verifique si la frase ingresada contiene la palabra izquierda
            if(decision.toLowerCase().contains("debugger")){
                arbol.debugger();
            }
            if (decision.toLowerCase().contains("izquierda")) {
                siguiente_nodo = nodo_actual.izquierdo;
            } else if (decision.toLowerCase().contains("derecha")) {
                siguiente_nodo = nodo_actual.derecho;
            } else{
                System.out.println("No te quieras pasar de listo noble aventurero, la opcion que has elegido no esta en tu poder.");
                continue;
            }

            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
            //condicional que verifique si el nodo actual es una hoja
            if(nodo_actual.izquierdo==null && nodo_actual.derecho==null){
                System.out.println("Parece que has llegado a un callejon sin salida, Una pista te sera otorgada sobre donde se ubica tu punto de llegada.");
                arbol.muestrallegada(nodo_actual,visitados,arbol.buscarnodo(arbol.raiz, p));
                System.out.println("En tu poder se haya la decision de cumplir tu destino, ¿Deseas intentarlo de nuevo? (Escribe 'intentar' para intentar de nuevo o 'salir' para abandonar el juego): ");
                decision = leer.nextLine();
                decision = decision.replaceAll("\\s", "");
                while(!decision.toLowerCase().contains("debugger")&&!decision.toLowerCase().contains("intentar")&&!decision.toLowerCase().contains("salir")){
                    System.out.println("No te quieras pasar de listo noble aventurero, la opcion que has elegido no esta en tu poder.");
                    decision = leer.nextLine();
                    decision = decision.replaceAll("\\s", "");
                }
                if(decision.toLowerCase().contains("debugger")){
                    arbol.debugger();
                }
                if (decision.toLowerCase().contains("intentar")) {
                    nodo_actual = arbol.raiz;

                    continue;
                }
                if (decision.toLowerCase().contains("salir")) {
                    System.out.println("Tu aventura en este misterioso bosque ha terminado, si deseas retomarla en otro momento te espero con los brazos abiertos.");
                    break;
                }
            }
            //condicional que verifique si el nodo siguiente es nulo
            if (siguiente_nodo == null) {
                System.out.println("Parece que tu destino no aguarda en esa direccion, Sabiamente considera otra opcion.");
            } else {

                while (true) {
                    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
                    System.out.println("De pronto se escucha un resonar a tu alrededor, \"Por esta zona solo ha de pasar el que una interrogante logré contestar\" ");
                    System.out.print(": " + nodo_actual.acertijo.getPregunta() + " ");
                    String respuesta = leer.nextLine();
                    respuesta = respuesta.replaceAll("\\s", "");

                    //valida que solo ingrese texto
                    while(!respuesta.matches("[a-zA-Z]+")){
                        System.out.println("En mi basto conocimiento no existe una lengua con tales palabras, Si conmigo te has de comunicar en mi lengua debes hablar, intentalo de nuevo:");
                        respuesta = leer.nextLine();
                        respuesta = respuesta.replaceAll("\\s", "");

                    }
                    if(respuesta.toLowerCase().contains("debugger")){
                        arbol.debugger();
                    }
                    if (respuesta.toLowerCase().contains("salir")) {
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
                        System.out.println("Tu aventura en este misterioso bosque ha terminado, si deseas retomarla en otro momento te espero con los brazos abiertos.");
                        break;
                    }
                    if ((respuesta.toLowerCase().contains(nodo_actual.acertijo.respuesta))) {
                        System.out.println("Tu respuesta ha sido de mi agrado, Puedes continuar tu viaje aventurero honrado.");
                        nodo_actual = siguiente_nodo;
                        break;
                    } else {
                        System.out.println("Tu respuesta no me satisface, Si intentas otra vez tal vez tu mente aclarés.");
                        //se le asigna un acertijo random de la lista de acertijos
                        nodo_actual.acertijo = arbol.Acertijosauxiliares.get((int) (Math.random() * arbol.Acertijosauxiliares.size()));
                        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
                    }
                }
            }
        }

        //Controlador de musica
        while (true) {
            System.out.println("::::::::::::::::::::::");
            welove.play();
            System.out.println("Escribe ´pausar´ para detener la musica");
            String decision = leer.nextLine();
            if (decision.toLowerCase().contains("pausar")) {
                welove.stop();
                break;
            }
        }
    }
}

