async function loadProducts() {
    const response = await fetch("http://localhost:8080/store");
    const products = await response.json();
    const productList = document.getElementById("productList");

    productList.innerHTML = ""; // Limpa a lista antes de atualizar

    products.forEach(product => {
        const li = document.createElement("li");
        li.innerText = `${product.name} - R$ ${product.price} - ${product.description} - 
        ${product.quantity}`;
        productList.appendChild(li);
    });
}

loadProducts();