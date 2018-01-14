var glAside; // Un variable global para el contexto WebGL

function startAside() {
  start();
  webGLStart();
  var canvas = document.getElementById("glcanvasAside");

  glAside = initWebGLAside(canvas);      // Inicializar el contexto GL
  
  // Solo continuar si WebGL esta disponible y trabajando
  
  if (glAside) {
    glAside.clearColor(0.0, 0.0, 0.0, 1.0);                      // Establecer el color base en negro, totalmente opaco
    glAside.enable(glAside.DEPTH_TEST);                               // Habilitar prueba de profundidad
    glAside.depthFunc(glAside.LEQUAL);                                // Objetos cercanos opacan objetos lejanos
    glAside.clear(glAside.COLOR_BUFFER_BIT|glAside.DEPTH_BUFFER_BIT);      // Limpiar el buffer de color asi como el de profundidad
  }
}

function initWebGLAside(canvas) {
  glA = null;
  
  try {
    // Tratar de tomar el contexto estandar. Si falla, retornar al experimental.
    glA = canvas.getContext("webgl") || canvas.getContext("experimental-webgl");
  }
  catch(e) {}
  
  // Si no tenemos ningun contexto GL, date por vencido ahora
  if (!glA) {
    alert("Imposible inicializar WebGL. Tu navegador puede no soportarlo.");
    glA = null;
  }
  
  return glA;
}

function webGLStart() {
    var canvas = document.getElementById("lesson01-canvas");
    initGL(canvas);
    initShaders();
    initBuffers();

    gl.clearColor(0.0, 0.0, 0.0, 1.0);
    gl.enable(gl.DEPTH_TEST);

    drawScene();
}



