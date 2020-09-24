# Android-GasAgua
Construção focada em sistema de pedido com integração do Whatsapp.



<h3>*Projeto amador para fins de aprendizagem.*</h3>
<h3>*App for learning purpose.*</h3>



<h4>Projeto:</h4>

App feito para encomenda dos produtos água e gás via Whatsapp. O pedido é feito via app e enviado a um número que for digitado no 
campo de telefone celular(55 (ddd) 9xxxxxxxx, sem espaçamento e sem caractere especial) e é enviado em forma de pedido ao número do destinatário.

<h4>Código da url que envia o pedido: </h4>

<pre><code>String url = "https://api.whatsapp.com/send?phone=" + celularNumero.getText() + "&text=---NOVO%20PEDIDO---
%20%0A%0ACliente%3A%20" + nome.getText()+"%0A%0AEndereco%3A%20"+endereco.getText()+"%0A%0AQuantidade%2F%20Produto%3A%20%0A"
+qtdp1.getSelectedItem()+" "+ep1.getSelectedItem()+"%20%0A%0AForma%20De%20Pagamento%3A%20"+formaDePag.getSelectedItem()+"%0A
Troco:%20"+troco.getText()+"%20%0AValor%20Total%3A%20R$%20"+valorT+"%0A%0A %20%0A FIM%20DO%20PEDIDO%0A";</code></pre>

<h4>Corpo do Pedido(mensagem):</h4>

---NOVO PEDIDO--- 

Cliente: x

Endereco: x

Quantidade/ Produto: 
1 Gás 13KG 

Forma De Pagamento: Cartão
Troco:  
Valor Total: R$ 85

  
 FIM DO PEDIDO
 
<h6>Criado por Malfaa</h6>
