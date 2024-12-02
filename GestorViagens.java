����   A  GestorViagens  java/lang/Object viagens Ljava/util/List; 	Signature Ljava/util/List<LViagem;>; gestorMotoristas LGestorMotoristas; gestorClientes LGestorClientes; gestorProdutos LGestorProdutos; <init> 5(LGestorMotoristas;LGestorClientes;LGestorProdutos;)V Code
     ()V  java/util/ArrayList
  	    	   	 
	    	     LineNumberTable LocalVariableTable this LGestorViagens; listarViagens & ( ' java/util/List ) * isEmpty ()Z	 , . - java/lang/System / 0 out Ljava/io/PrintStream; 2 Nenhuma viagem cadastrada.
 4 6 5 java/io/PrintStream 7 8 println (Ljava/lang/String;)V
  : ; < getClass ()Ljava/lang/Class;   > ? @ accept 4(Ljava/io/PrintStream;)Ljava/util/function/Consumer; & B C D forEach  (Ljava/util/function/Consumer;)V StackMapTable iniciarViagem (Ljava/util/Scanner;)V I &Digite uma descrição para a viagem: 
 4 K L 8 print
 N P O java/util/Scanner Q R nextLine ()Ljava/lang/String; T Digite a cidade de origem:  V Digite a cidade de destino:  X #Selecione um motorista disponível:
 Z \ [ GestorMotoristas ]  listar _ Digite o ID do motorista: 
 N a b c nextInt ()I
 Z e f g buscarPorId (I)LMotorista;
 i k j 	Motorista l * 
isEmViagem n %Motorista inválido ou já em viagem. p Selecione um cliente:
 r \ s GestorClientes u Digite o ID do cliente: 
 r w f x (I)LCliente; z Cliente inválido. | /Selecione os produtos (digite 0 para encerrar):
 ~ \  GestorProdutos � Digite o ID do produto: 
 ~ � f � (I)LProduto; & � � � add (Ljava/lang/Object;)Z � Produto inválido. � *Você deve selecionar ao menos um produto. � Viagem
 � �  � ](Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;LMotorista;LCliente;)V
 i � � � setEmViagem (Z)V � Viagem iniciada com sucesso! scanner Ljava/util/Scanner; 	descricao Ljava/lang/String; cidadeOrigem cidadeDestino idMotorista I 	motorista LMotorista; 	idCliente cliente 	LCliente; produtosSelecionados 	idProduto produto 	LProduto; 
novaViagem LViagem; LocalVariableTypeTable Ljava/util/List<LProduto;>; � java/lang/String � Cliente � Produto finalizarViagem
  � $  � &Digite o ID da viagem para finalizar: 
  � � � buscarViagemPorId (I)LViagem; � Viagem não encontrada. � 
Finalizada
 � � � R 	getStatus
 � � � � equals � A viagem já está finalizada.
 � � � 8 	setStatus
 � � � � getMotorista ()LMotorista; � Viagem finalizada com sucesso! idViagem viagem & � � � stream ()Ljava/util/stream/Stream;  � � � test !(I)Ljava/util/function/Predicate; � � � java/util/stream/Stream � � filter 9(Ljava/util/function/Predicate;)Ljava/util/stream/Stream; � � � � 	findFirst ()Ljava/util/Optional;
 � � � java/util/Optional � � orElse &(Ljava/lang/Object;)Ljava/lang/Object; id lambda$1 (ILViagem;)Z
 � � � c getId 
SourceFile GestorViagens.java BootstrapMethods
 � � � "java/lang/invoke/LambdaMetafactory � � metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; � (Ljava/lang/Object;)V �
 4 � 7 � � (LViagem;)V  �
  � � (LViagem;)Z InnerClasses
 %java/lang/invoke/MethodHandles$Lookup java/lang/invoke/MethodHandles Lookup !                	 
                     {     *� *� Y� � *+� *,� *-� �                       !   *     " #      	 
               $      r     .*� � % � � +1� 3� *� � +Y� 9W� =  � A �                   -  !       . " #   E      F G    �    B� +H� J+� MM� +S� J+� MN� +U� J+� M:� +W� 3*� � Y� +^� J+� `6+� MW*� � d:� � h� � +m� 3�� +o� 3*� � q� +t� J+� `6+� MW*� � v:� � +y� 3�� Y� :	� +{� 3*� � }� +�� J+� `6
+� MW
� � +*� 
� �:� 	� � W��˲ +�� 3���	� % � � +�� 3�� �Y,-	� �:
*� 
� � W� �� +�� 3�        � -            "  ( ! 0 " 7 # ? $ E % J & U ( b ) j * k - s . z / � 0 � 1 � 2 � 4 � 5 � 6 � 9 � : � ; � = � > � ? � @ � B � C � D � E � F � < J K L O' P3 Q9 RA S !   �   B " #    B � �  5 � �  ( � �  ( � �  E � � �  U � � �  � � � �  � � � �  � � �  	 � 2 � � 
 �  � � '  � � 
 �     � � � � 	 E   8 � b   N � � � i  � : ��  &� �  �� 
  � G     �     Y*� �� +�� J+� `=+� MW*� �N-� � +�� 3� 0�-� �� Ù � +ƶ 3� -�� �-� �� �� +϶ 3�        :    V  W  X  Y  Z  \   ] ( ^ 7 _ ? ` B a H b P c X e !   *    Y " #     Y � �   H � �   = � �  E    � + �  � �     e     !*� � � � �  � � � � � �� ��            h 	 i  j  k   h !       ! " #     ! � � 
 � �     C     +� �� � �            i !        � �  E    @  �    � �     �  � � �    
 	 