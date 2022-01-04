Repositório do sistema Ceos

PRIMEIRA AUTOMAÇÃO SISTEMA CEOS

1 - APRESENTAÇÃO INICIAL.

Este é um projeto inicial de automação parcial do sistema CEOS, apenas para apresentação.

2 - ESPECIFICAÇÃO TÉCNICA

2.1 - LINGUAGEM

Este projeto foi desenvolvido na linguagem Java.

2.2 - API - FERRAMENTAS UTILIZADAS

Este projeto foi desenvolvido utilizando a API Selenide, em conjunto com a ferramenta de testes integrada TestNG.

3 - DA AUTOMAÇÃO EM SÍ

3.1 - CENÁRIOS AUTOMATIZADOS

Os cenários automatizados foram o de recebimento e de expedição.

O cenário de cadastro de expedição já comporta o de requisição, que também foi automatizado. Após o clique em "Run", todo o processo inicia pelo cadastro de requisição e finaliza com o cadastro de expedição.

O cenário de cadastro de recebimento já comporta também os de emissão de ordem de fornecimento e o de documento de recebimento (ambos também automatizados). Após o clique em "Run", todo o processo inicia pelo cadastro de ordem de fornecimento, passando em sequência pelo cadastro de documento de recebimento finalizando com o cadastro do recebimento.

4 - CONSIDERAÇÕES FINAIS

Deve-se ter em mente que todo processo de automação requer basicamente três passos:

1 - Entender

2 - Aprender

3 - Desenvolver

Deve-se respeitar a ordem dos eventos, não pular etapas, pois determinados elementos são visíveis apenas depois de disparados os eventos que o precedem.

Deve-se respeitar campos condicionais, alguns campos "jamais" devem ter dados aleatórios, como datas por exemplo, uma vez que não respeitadas as condições específicas das datas, tratrá erros para a automação.

Deve-se respeitar a infra dos ambientes envolvidos, uma vez que a aplicação utilize o modelo cliente/servidor, o tempo de pedido/resposta pode variar de ambiente para ambiente, o que vai levar a configuaração de "seleps/waits" específicos para cada um(ambiente), ou então, o desenvolvedor poderá configurar um tempo padrão maior para tentar se adequar a diversos ambientes novos ou desconhecidos.

Sob estas premissas básicas, a automação não será problema.

PAULO GUERRA.