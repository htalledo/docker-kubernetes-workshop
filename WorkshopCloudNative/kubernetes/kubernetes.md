# Obtener el contexto actual
kubectl config current-context

# Aplicar un yaml en kubernetes (de forma declarativa)
kubectl apply -f <nombre_archivo.yml>

# Obtener los deployments
kubectl get deployments

# Obtener el detalle del estado actual de un deployment , incluido eventos de estatus
kubectl get deployments mongodb -oyaml

# Describir las configuraciones y eventos de su deployment
kubectl describe deployment mongodb

# Obtener el detalle del estado actual de un pod , incluido eventos de estatus
kubectl get pod mongodb-asduhasd -oyaml

# Describir las configuraciones y eventos de su pod
kubectl describe pod mongodb-asdfashdfa

# Obtener los logs de un pod
kubectl logs mongodb-5b6c8d6bf4-4qt2q

# Editar inline un recurso
kubectl edit deployment employee

# Crear deployment (imperativamente)
kubectl create deployment hello-busybox --image=busybox -- /bin/sh -c "while true; do echo 'Hello world'; sleep 10; done"

# Dry run para generar el yaml
kubectl create deployment hello-busybox --image=busybox --dry-run=client -o yaml -- /bin/sh -c "while true; do echo 'Hello world'; sleep 10; done"