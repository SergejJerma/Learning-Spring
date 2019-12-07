<#import "parts/common.ftl" as c> 
<@c.page>
<ul class="list-group">
</ul>
<li class="list-group-item active">History</li>
<#list historyList?ifExists as text>
<li class="list-group-item">Request: <div>${text.textBody}</div> <div>Result:</div> <#list text.lastLetters as letter> <div>${letter.lastLetter} ${letter.wordsNumber}<#list letter.words as word> ${word} </#list></div></#list></li>
</#list>

</@c.page>