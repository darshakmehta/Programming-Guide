void Print(Node *head)
{
    if(head==NULL)
        return;
    else
    {
    while(head!=NULL)
    {
    printf("%d\n",head->data);
        head=head->next;
    }
    }
  // This is a "method-only" submission. 
  // You only need to complete this method. 
}