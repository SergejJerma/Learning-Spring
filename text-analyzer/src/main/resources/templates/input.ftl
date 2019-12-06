<#import "parts/common.ftl" as c> <@c.page>
<#if !list??>
<div class="form-group mt-3">
	<form method="post" enctype="multipart/form-data">
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Input text here:</span>
			</div>
			<textarea type="text" name="text" class="form-control" aria-label="Input text here:"></textarea>

		</div>
		<br/>
		<div class="form-group">
			<button type="submit" class="btn btn-info">Analyze</button>
		</div>

	</form>
</div>
</#if>
<#if list??>
<#list list?ifExists as lastLetter>
${lastLetter.lastLetter}
</#list>
</#if>
</@c.page>