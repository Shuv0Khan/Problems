### Live Template setting in intellij
---

1. Go to Settings->Editor->Live Templates
2. Under Test create a new template group test
3. In the template text -
```
@org.junit.jupiter.api.Test
@org.junit.jupiter.api.DisplayName("$TEST_NAME$")
void $METHOD_NAME$() {
    $END$
    $BODY$
}
```
4. Edit Variables and do -
   
   | Name | Expression | Default value | Skip if defined|
   |------|------------|---------------|-----------|
   | TEST_NAME | | "Test name" | |
   | METHOD_NAME| camelCase(TEST_NAME)| "methodName"| |
   |BODY| | "org.junit.jupiter.api.Assertions.fail(\"Not Implemented\");"|x|
   
5. Set "Expand with - Default"
6. Mark all three options.
7. Set "Applicable in Java: declaration"
