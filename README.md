# Reto 10

**Arquitectura, estilo MVC (Model-View-Controller) con paquete Command:**
El proyecto desacopla la representación del estado de las máquinas de la lógica de resolución. En el paquete **model**, `MachineLights` y `MachineVolts` (implementados como Records) almacenan los estados inmutables de los objetivos y configuraciones de botones. En el paquete **view**, `ConsolePrinter` se limita a mostrar los resultados. En el **controller**, `DeviceController` actúa como intermediario, recibiendo los modelos y seleccionando el comando de optimización adecuado para ejecutar.

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Alta cohesión. `MachineLigthsParser` y `MachineVoltParser` solo saben interpretar texto, mientras que los comandos (`InitializationCommand`, `VoltRegulerCommand`) encapsulan algoritmos complejos de optimización combinatoria y búsqueda.
* **Inversión de Dependencias (DIP):** El sistema es modular. El uso de la interfaz `LightsCommand` permite que el controlador ejecute cualquier tipo de optimización sin conocer los detalles del algoritmo.
* **Abierto-Cerrado (OCP):** El diseño permite la extensión. Si aparece un nuevo tipo de máquina con reglas diferentes, basta con crear un nuevo parser y un nuevo comando sin modificar la lógica existente del controlador.

**Extras:**
* **Paquete Command:** Fundamental para aislar la lógica de "Fuerza Bruta con Bitmasks" (Parte 1) de la "Búsqueda con Poda y Memoization" (Parte 2).
* **Optimizaciones Algorítmicas:**
    * **Bit Manipulation (Parte 1):** Uso de operaciones a nivel de bits (`<<`, `&`, `^`) para probar las combinaciones.
    * **Memoización y Poda (Parte 2):** Uso de mapas de estados para evitar re-calcular ramas del árbol ya visitadas y poda (Branch & Bound) para descartar soluciones peores que la actual.
* **Java Records:** Uso extensivo para definir estructuras de datos inmutables y claves de estado de forma concisa.
