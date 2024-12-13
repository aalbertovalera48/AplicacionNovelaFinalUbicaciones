# Aplicación de Gestión de Novelas Final Ubicaciones - Alberto Valera

Link al Repositorio: https://github.com/aalbertovalera48/AplicacionNovelaFinalUbicaciones.git

Link a la base de datos Firebase: https://console.firebase.google.com/project/gestion-de-novelas-actualizado/database/gestion-de-novelas-actualizado-default-rtdb/data/~2F?hl=es-419

## Objetivo
El objetivo del proyecto es extender la funcionalidad de la práctica anterior "Gestión Novelas". Se busca conectar el código fuente con una base de datos de Firebase e implementar mecanismos de sincronización en segundo plano, permitiendo a los usuarios gestionar su biblioteca de novelas de manera más eficiente y accesible y viendo la ubicación de cada una de ellas en un mapa geográfico.

## Características Principales
- **Interfaz de usuario amigable**: Diseño intuitivo que permite una fácil navegación y gestión de novelas.
- **Sincronización en tiempo real**: Actualizaciones automáticas de la lista de novelas utilizando Firebase.
- **Gestión de favoritos**: Permite a los usuarios marcar novelas como favoritas y gestionarlas de forma sencilla.
- **Notificaciones programadas**: Utiliza AlarmManager para recordar a los usuarios sobre sus novelas.
- **Funcionalidades geográficas**: Integración de mapas para mostrar la ubicación de las novelas.

## Funcionalidades de la Aplicación
### Pantalla de Lista de Novelas:
- Muestra una lista de novelas almacenadas en la base de datos.
- Permite agregar una nueva novela mediante un formulario.
- Opción para marcar una novela como favorita.
- Navegación a la pantalla de detalles de cada novela seleccionada.

### Pantalla de Detalles de la Novela:
- Muestra información detallada de la novela seleccionada (título, autor, año, sinopsis).
- Permite a los usuarios añadir reseñas y visualizar las existentes.
- Opción para marcar o desmarcar la novela como favorita.

### Pantalla de Agregar Novela:
- Incluye un formulario para introducir los detalles de una nueva novela (título, autor, año de publicación, sinopsis).
- Valida los campos de entrada y guarda la novela en la lista.

### Notificaciones Programadas:
- Utiliza AlarmManager para programar recordatorios sobre las novelas.
- Permite que los usuarios reciban alertas relacionadas con sus novelas favoritas.

### Funcionalidades Geográficas:
- **Mapa de Ubicaciones**: Muestra un mapa con las ubicaciones de las novelas.
- **Marcadores de Novelas**: Añade marcadores en el mapa para cada novela con su ubicación.
- **Detalles en el Mapa**: Al hacer clic en un marcador, se muestra el título de la novela.

## Clases y Actividades
### MainActivity:
- Controla la actividad principal de la aplicación, donde se muestran las novelas.
- Maneja la lógica para añadir y eliminar novelas, así como para mostrar detalles de cada novela.
- Contiene métodos para interactuar con el ListView de novelas y gestionar la sincronización con Firebase.

### FavoritosActivity:
- Maneja la visualización de las novelas marcadas como favoritas.
- Permite al usuario ver y gestionar su lista de novelas favoritas.

### LocationActivity:
- Muestra un mapa con las ubicaciones de las novelas.
- Añade marcadores en el mapa para cada novela con su ubicación.

### Novela:
- Clase modelo que representa una novela.
- Contiene atributos como título, autor, año, sinopsis, ubicación (latitud y longitud) y un indicador de si la novela es favorita.
- Proporciona métodos para acceder y modificar estos atributos.

### NovelaAdapter:
- Adaptador personalizado para el ListView de novelas.
- Se encarga de enlazar los datos de las novelas con las vistas en la interfaz de usuario.
- Facilita la visualización de cada elemento de la lista con el formato adecuado.

### AlarmManager:
- Clase utilitaria para manejar las alarmas y recordatorios.
- Utiliza el AlarmManager de Android para programar tareas periódicas y gestionar notificaciones.

### Conexion:
- Clase que extiende BroadcastReceiver para recibir y manejar cambios en la conectividad de red.
- Notifica a la aplicación sobre cambios en la conexión para gestionar adecuadamente la sincronización con Firebase.

### FirebaseConfig:
- Clase encargada de gestionar la conexión con Firebase.
- Contiene métodos para cargar, agregar y eliminar novelas en la base de datos de Firebase.
- Facilita la sincronización de datos entre la aplicación y Firebase.

### SyncTask:
- Clase que extiende AsyncTask para realizar tareas de sincronización de datos en segundo plano.
- Permite que la aplicación realice operaciones de red sin bloquear la interfaz de usuario.

## Estructura del Código
### Archivo Pantallas.kt
La lógica de la aplicación está centralizada en este archivo, gestionando tanto la lista de novelas como la navegación entre pantallas.

### Componentes Principales:
- **NovelasListScreen**: Pantalla principal que muestra la lista de novelas y permite navegar a las pantallas de detalles o agregar una nueva novela.
- **NovelaDetailsScreen**: Pantalla donde se presentan los detalles completos de la novela seleccionada. Se permite añadir reseñas y marcarla como favorita.
- **AddNovelaScreen**: Pantalla con un formulario para añadir una nueva novela. Incluye validación de campos y agrega la novela a la lista al completarse.

## Modelo de Datos Novela
El modelo de datos de la novela incluye propiedades como:
- **id**: Identificador único de la novela.
- **titulo**: Título de la novela.
- **autor**: Autor de la novela.
- **añoPublicacion**: Año de publicación.
- **sinopsis**: Resumen de la novela.
- **esFavorita**: Booleano que indica si la novela es favorita.
- **reseñas**: Lista mutable de reseñas asociadas a la novela.
- **latitud**: Latitud de la ubicación de la novela.
- **longitud**: Longitud de la ubicación de la novela.

## Navegación y Estado
Se utiliza NavController para la navegación entre pantallas. Los estados de la lista de novelas y las reseñas se gestionan mediante remember y mutableStateListOf, lo que permite una administración eficiente y reactiva del estado.

## Integración con Firebase
La aplicación utiliza Firebase como base de datos para almacenar las novelas. Se han añadido 20 novelas de ejemplo para probar la aplicación. FirebaseHelper gestiona todas las operaciones relacionadas con la base de datos, permitiendo que las novelas se sincronicen y persistan a través de diferentes sesiones de la aplicación.

## Archivos XML
### activity_main.xml:
- Diseño de la actividad principal.
- Contiene elementos como TextView, ListView y botones para gestionar novelas.
- Diseñado para ser amigable y responsive.

### favoritos_activity.xml:
- Diseño para la visualización de novelas favoritas.
- Similar a activity_main, pero centrado en las novelas marcadas como favoritas.

### agregar_novela.xml:
- Diseño del diálogo para agregar una nueva novela.
- Campos de entrada para el título, autor, año y sinopsis.

### eliminar_novela.xml:
- Diseño del diálogo para eliminar una novela.
- Permite seleccionar una novela de la lista para eliminarla de la biblioteca.

### detalles_novela.xml:
- Diseño para mostrar detalles de una novela específica.
- Incluye título, autor, año, sinopsis y un botón para marcarla como favorita.

### item_novela.xml:
- Diseño para cada elemento en la lista de novelas.
- Define la apariencia de cada novela en el ListView.

### buscar_novela.xml:
- Diseño para la interfaz de búsqueda de novelas.
- Incluye campos para ingresar el título de la novela a buscar.

### progress_dialog.xml:
- Diseño para mostrar un diálogo de progreso durante las operaciones de carga y sincronización.

### ic_sync.xml:
- Icono utilizado para representar la sincronización en la interfaz.

### notification_icon.xml:
- Icono utilizado en las notificaciones de la aplicación.

### circular_background_sync.xml:
- Diseño de fondo utilizado durante las operaciones de sincronización.

## Requisitos
- **Android Studio**: Versión recomendada 4.1 o superior.
- **SDK de Android**: Nivel mínimo 21.
- **Conexión a Internet**: Necesaria para sincronizar datos con Firebase.

## Conclusión
La aplicación de gestión de novelas no solo consolida conocimientos clave en el desarrollo de interfaces modernas con Jetpack Compose y Kotlin, sino que también proporciona funcionalidades esenciales para la gestión de una biblioteca personal de novelas. La experiencia de usuario se enriquece a través de la interacción fluida, la sincronización de datos en tiempo real y la implementación de notificaciones programadas.

## Aprendizajes Clave
- **Interfaz de Usuario con Jetpack Compose**: Se ha aprendido a estructurar y organizar las pantallas usando composables, creando interfaces intuitivas y reactivas.
- **Navegación**: Implementación de una navegación eficaz entre pantallas usando NavController.
- **Gestión del Estado**: El manejo de listas y estados con remember y mutableStateListOf ha sido crucial para mantener la aplicación actualizada de manera eficiente.
- **Integración de Firebase**: Comprensión de cómo conectar la aplicación con una base de datos en la nube para la persistencia y sincronización de datos.
- **Notificaciones Programadas**: Desarrollo de habilidades para utilizar AlarmManager para gestionar recordatorios y alertas.

## Implicaciones Futuras
Este proyecto es una base sólida para la creación de aplicaciones Android más complejas. En el futuro, se podrían implementar características adicionales, como:
- Persistencia de datos utilizando Room para una gestión local de la base de datos.
- Integración de APIs externas para enriquecer la experiencia del usuario, como recomendaciones de novelas.
- Desarrollo de una versión web o multiplataforma para ampliar el acceso a la aplicación.
