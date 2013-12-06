Scenario: User can submit feedback
When I submit a feedback with my name, 'receiver name' and 'you rock'
Then I should see 'receiver name'
And I should see the message 'you rock'
And I should see my 'my name'