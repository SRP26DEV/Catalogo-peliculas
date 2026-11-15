import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Tamaño máximo del catálogo
        int capacidad = 100;
        
        // Arrays paralelos para almacenar los datos de las películas
        String[] titulos = new String[capacidad];
        String[] directores = new String[capacidad];
        String[] generos = new String[capacidad];
        int[] anios = new int[capacidad];
        double[] calificaciones = new double[capacidad];
        
        // Variable para llevar el conteo de películas registradas
        int totalPeliculas = 0;
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("       🎬 CATÁLOGO DE PELÍCULAS         ");
            System.out.println("========================================");
            System.out.println("1. Agregar película");
            System.out.println("2. Mostrar películas");
            System.out.println("3. Buscar película");
            System.out.println("4. Modificar película");
            System.out.println("5. Eliminar película");
            System.out.println("6. Mostrar información");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            // Validación básica para evitar errores si el usuario ingresa letras
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } else {
                System.out.println("❌ Opción inválida. Por favor, ingrese un número del 1 al 7.");
                scanner.nextLine(); // Limpiar entrada incorrecta
                continue;
            }

            switch (opcion) {
                case 1: // ➕ Agregar película
                    if (totalPeliculas >= capacidad) {
                        System.out.println("⚠️ El catálogo está lleno. No se pueden agregar más películas.");
                        break;
                    }

                    System.out.println("\n--- REGISTRAR NUEVA PELÍCULA ---");
                    System.out.print("Ingrese el título: ");
                    titulos[totalPeliculas] = scanner.nextLine();

                    System.out.print("Ingrese el director: ");
                    directores[totalPeliculas] = scanner.nextLine();

                    System.out.print("Ingrese el género: ");
                    generos[totalPeliculas] = scanner.nextLine();

                    System.out.print("Ingrese el año: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("❌ Año inválido. Ingrese un número entero:");
                        scanner.next();
                    }
                    anios[totalPeliculas] = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Ingrese la calificación (0.0 - 10.0): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("❌ Calificación inválida. Ingrese un número decimal:");
                        scanner.next();
                    }
                    calificaciones[totalPeliculas] = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    totalPeliculas++;
                    System.out.println("✅ Película agregada correctamente.");
                    break;

                case 2: // 📋 Mostrar películas
                    if (totalPeliculas == 0) {
                        System.out.println("\n📭 No hay películas registradas.");
                    } else {
                        System.out.println("\n========================================");
                        System.out.println("         PELÍCULAS REGISTRADAS          ");
                        System.out.println("========================================");
                        for (int i = 0; i < totalPeliculas; i++) {
                            System.out.println("Película #" + (i + 1));
                            System.out.println("Título: " + titulos[i]);
                            System.out.println("Director: " + directores[i]);
                            System.out.println("Género: " + generos[i]);
                            System.out.println("Año: " + anios[i]);
                            System.out.println("Calificación: " + calificaciones[i]);
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;

                case 3: // 🔍 Buscar película
                    if (totalPeliculas == 0) {
                        System.out.println("\n📭 No hay películas registradas en el catálogo.");
                        break;
                    }

                    System.out.print("\nIngrese el título de la película a buscar: ");
                    String tituloBusqueda = scanner.nextLine();
                    int indiceEncontrado = -1;

                    for (int i = 0; i < totalPeliculas; i++) {
                        if (titulos[i].equalsIgnoreCase(tituloBusqueda)) {
                            indiceEncontrado = i;
                            break;
                        }
                    }

                    if (indiceEncontrado != -1) {
                        System.out.println("\n✨ Película encontrada:");
                        System.out.println("Título: " + titulos[indiceEncontrado]);
                        System.out.println("Director: " + directores[indiceEncontrado]);
                        System.out.println("Género: " + generos[indiceEncontrado]);
                        System.out.println("Año: " + anios[indiceEncontrado]);
                        System.out.println("Calificación: " + calificaciones[indiceEncontrado]);
                    } else {
                        System.out.println("❌ No se encontró la película.");
                    }
                    break;

                case 4: // ✏️ Modificar película
                    if (totalPeliculas == 0) {
                        System.out.println("\n📭 No hay películas para modificar.");
                        break;
                    }

                    System.out.print("\nIngrese el título de la película que desea modificar: ");
                    String tituloModificar = scanner.nextLine();
                    int indiceModificar = -1;

                    for (int i = 0; i < totalPeliculas; i++) {
                        if (titulos[i].equalsIgnoreCase(tituloModificar)) {
                            indiceModificar = i;
                            break;
                        }
                    }

                    if (indiceModificar != -1) {
                        System.out.println("Película encontrada. Ingrese los nuevos datos:");
                        
                        System.out.print("Nuevo director (" + directores[indiceModificar] + "): ");
                        directores[indiceModificar] = scanner.nextLine();

                        System.out.print("Nuevo género (" + generos[indiceModificar] + "): ");
                        generos[indiceModificar] = scanner.nextLine();

                        System.out.print("Nuevo año (" + anios[indiceModificar] + "): ");
                        anios[indiceModificar] = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nueva calificación (" + calificaciones[indiceModificar] + "): ");
                        calificaciones[indiceModificar] = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("✅ Película modificada correctamente.");
                    } else {
                        System.out.println("❌ No se encontró la película para modificar.");
                    }
                    break;

                case 5: // 🗑️ Eliminar película
                    if (totalPeliculas == 0) {
                        System.out.println("\n📭 No hay películas para eliminar.");
                        break;
                    }

                    System.out.print("\nIngrese el título de la película que desea eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    int indiceEliminar = -1;

                    for (int i = 0; i < totalPeliculas; i++) {
                        if (titulos[i].equalsIgnoreCase(tituloEliminar)) {
                            indiceEliminar = i;
                            break;
                        }
                    }

                    if (indiceEliminar != -1) {
                        System.out.println("¿Está seguro de eliminar esta película?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        System.out.print("Seleccione una opción: ");
                        int confirmacion = scanner.nextInt();
                        scanner.nextLine();

                        if (confirmacion == 1) {
                            // Desplazar los elementos hacia la izquierda para llenar el espacio vacío
                            for (int i = indiceEliminar; i < totalPeliculas - 1; i++) {
                                titulos[i] = titulos[i + 1];
                                directores[i] = directores[i + 1];
                                generos[i] = generos[i + 1];
                                anios[i] = anios[i + 1];
                                calificaciones[i] = calificaciones[i + 1];
                            }
                            totalPeliculas--;
                            System.out.println("✅ Película eliminada correctamente.");
                        } else {
                            System.out.println("⚠️ Operación cancelada.");
                        }
                    } else {
                        System.out.println("❌ No se encontró la película para eliminar.");
                    }
                    break;

                case 6: // ℹ️ Información del programa
                    System.out.println("\n========================================");
                    System.out.println("         INFORMACIÓN DEL PROYECTO       ");
                    System.out.println("========================================");
                    System.out.println("Nombre: Catálogo de Películas");
                    System.out.println("Lenguaje: Java (Consola)");
                    System.out.println("Proyecto realizado por el Equipo 1:");
                    System.out.println("- Integrante 1 (Menú y navegación)");
                    System.out.println("- Integrante 2 (Registro y visualización)");
                    System.out.println("- Integrante 3 (Búsqueda y modificación)");
                    System.out.println("- Integrante 4 (Eliminación y validaciones)");
                    break;

                case 7: // 🚪 Salir
                    System.out.println("\n👋 ¡Gracias por usar el Catálogo de Películas! Hasta pronto.");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}