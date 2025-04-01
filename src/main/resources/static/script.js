async function loadProducts() {
    const response = await fetch("http://localhost:8080/store"); // Conexão com a URL
    const products = await response.json(); // Faz com que receba um jSON

    const productList = document.getElementById("productList");

    productList.innerHTML = ""; // Limpa a lista antes de atualizar

    products.forEach(product => {
        const li = document.createElement("li");
        // Pega os valores do JSON e aicionam ao LI
        li.innerText = `id: ${product.id}
         nome: ${product.name} \n
         - R$ ${product.price} \n
          ${product.description} - 
         quantidade: ${product.quantity}`;
        productList.appendChild(li);
    });
}
loadProducts();