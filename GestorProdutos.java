����   A �  GestorProdutos  Gestor <init> ()V Code
  	   LineNumberTable LocalVariableTable this LGestorProdutos; criarEntidade (Ljava/util/Scanner;)LProduto;	    java/lang/System   out Ljava/io/PrintStream;  Digite o nome do produto: 
    java/io/PrintStream   print (Ljava/lang/String;)V
  !   java/util/Scanner " # nextLine ()Ljava/lang/String; % Digite a quantidade: 
  ' ( ) nextInt ()I + Produto
 * -  . (Ljava/lang/String;I)V scanner Ljava/util/Scanner; nome Ljava/lang/String; 
quantidade I buscarPorId (I)LProduto;	  8 9 : 	entidades Ljava/util/List; < > = java/util/List ? @ stream ()Ljava/util/stream/Stream;   B C D test !(I)Ljava/util/function/Predicate; F H G java/util/stream/Stream I J filter 9(Ljava/util/function/Predicate;)Ljava/util/stream/Stream; F L M N 	findFirst ()Ljava/util/Optional;
 P R Q java/util/Optional S T orElse &(Ljava/lang/Object;)Ljava/lang/Object; id buscarPorNome (Ljava/lang/String;)LProduto;  Y C Z 2(Ljava/lang/String;)Ljava/util/function/Predicate; atualizarEntidade (LProduto;Ljava/util/Scanner;)V
 * ^ _ # getNome  a b c makeConcatWithConstants &(Ljava/lang/String;)Ljava/lang/String;
 * e f  setNome
 * h i ) getQuantidade  k b l (I)Ljava/lang/String;
 * n o p setQuantidade (I)V produto 	LProduto; (I)Ljava/lang/Object;
  u 5 6 &(Ljava/lang/String;)Ljava/lang/Object;
  x V W ((Ljava/lang/Object;Ljava/util/Scanner;)V
  { [ \ '(Ljava/util/Scanner;)Ljava/lang/Object;
  ~   lambda$0 (ILProduto;)Z
 * � � ) getId StackMapTable lambda$1 (Ljava/lang/String;LProduto;)Z
 � � � java/lang/String � � equalsIgnoreCase (Ljava/lang/String;)Z 
SourceFile GestorProdutos.java 	Signature LGestor<LProduto;>; BootstrapMethods
 � � � "java/lang/invoke/LambdaMetafactory � � metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; � (Ljava/lang/Object;)Z �
  �  � � (LProduto;)Z � �
  � � � � �
 � � � $java/lang/invoke/StringConcatFactory b � �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; � � Digite o novo nome (atual: ):  � %Digite a nova quantidade (atual: ):  InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup !               /     *� �    
                           �     )� � +� M� $� +� &>+� W� *Y,� ,�    
           	  
        *    )       ) / 0    1 2    3 4   5 6     e     !*� 7� ; � A  � E � K � O� *�    
        	                !       ! U 4   V W     e     !*� 7� ; +� X  � E � K � O� *�    
        	                !       ! 1 2   [ \     �     :� +� ]� `  � ,� N+-� d� +� g� j  � ,� &6,� W+� m�    
   "    !  "  #  % ( & . ' 3 ( 9 )    4    :       : q r    : / 0   & 1 2  .  3 4 D 5 s     &     *� t�    
             D V v     &     *+� w�    
             D [ y     *     
*+� *,� z�    
             D  |     &     *+� }�    
             
  �     C     +� �� � �    
                q r  �    @
 � �     3     	+� ]*� ��    
               	 q r   �    � �    � �   "  �  � � � �  � � � �  � �  � �   
  � � � 